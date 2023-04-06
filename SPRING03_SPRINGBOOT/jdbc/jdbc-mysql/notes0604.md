01. create maven project -> quickstart last version -> default interactions
02. add db ependecies in pom -> il connettore viene usato in fase di runtine e l'interfaccia java.sql sono tutte già caricate, quindi <scope>runtime</scope>.
Se manca la dipendenza poi lo fa runtime mentre compila, altrimenti si può forzare tramite maven in sezione dependecies.
03. Dependencies Springframework da caricare: spring-context (aop, bean, core, expression), spring-jdbc(stessa versione di context)
-ci possono essere conflitti tra librerie di db e springframework risolvivili con Maven.
04. Creare appCongif con beans:

Bean1. DataSoure -> componente informatico che si gestisce in autonomia tutti le connessione a un database. Ne esistono svariati tipi. L'ultimo strato di comunicazione col db è sempre jdbc. Utile per generare il jdbc template.
-Istanziare un nuovo driver manager di data source.
-setDriver, setUrl, setUserName, setPassword.
--configurabile anche il numero massimo di connessioni e timeout, esecuzione automatica.

Bean2: jdbctemplate -> getDataSource. In alternatica autowired del componente datasource.

05. Model: folder sottopackage di aulab con le classi delle tabelle. Lasciare constructor vuoto e usare i getter/setter.
-Generare già con Java Project per configurare il package.

06. Se a una riga di una tabella di db corrisponde un attributo di una classe model, si può costruire un DataAccessObject o DAO. Come in repository, nel dao si può gestire tutto quello che è inerente al modello.
- Bisogna passargli il jdbc template ( configurato nel context), quindi deve esser un component.
- Eventualmente creare una interfaccia che riporti i vari metodi, ad esempio: public List<T> getData();
                    public T getOne(BigInteger id);
                    public boolean insert(T model);
                    public boolean update(BigInteger id, T model);
                    public boolean delete(BigInteger id);

I. getOne()                   
Scrivere una query su jdbctemplate (getOne); tre possibili metodi:
se solo
    jdbcTemplate.queryForObject("sql WHERE id= ? -in base al numero dei parametri- -o named parameter generando una mappa che li contenga-", rowmapper -creato da Spring se la logica nomeAttributo == nomeDB assegna a ogni attributo il suo campo-);
    -- BeanPropertyRowMapper se standard altrimenti custom made. Classe base dello Springframework che crea gli oggetti necessari mappandoli campo per proprietà.
    -- dopo il rowmapper inserire tanti parametri quanti richiesti.
    -- per testare istanziare un nuovo AnnotatioConfigApplocationContext e chiedergli il Dao ( getBean classe implementata). Infine assegnare a istanziazione model class il metodo del dao 
    per ottenere un suo oggetto tramite id.

II.count()
Contare le righe count() richiamare queryForObject dovendo ricercare solo un elemento tramite SELECT FROM standard ( int se associato a Integer.class nel required type viene accettato da Java, se si vuole mantenere una certa coerenza logica invece inserire solo Integer).


III.getData()
Select senza parametro impiegando il metodo .query(), che restituisce una lista, rispettando il mapping della classe passata.

IV.insert()
"INSERT into table (parameters) value(?)" tramite metodo update(). Se possibile recuperare i valori tramite model.
Update resituisce sempre il valore int delle righe su cui ha agito.
Per controllare se funziona istanziare in App un nuovo oggetto restaurant con set dei dati interessati. Poi applicare dao.insert().

V.delete()
Si implementa sempre con update(). Non serve parametro model, solo id. ("DELETE FROM table WHERE id = ?", parameter); 
Se agisce restituisce sempre un valore int maggiore di 0

VI.update()
Input id e model, stesso meccanismo di restituzione int di IV e V. "UPDATE table SET parameters = ? WHERE id = ?", model.getters, id); 
return int value compared; 

TUTTO QUESTO EST PERSISTENTE.
------------------------------------------------

- SOC: service -> logica di business, 
dao -> tutto quello che serve per comunicare col db,
repository -> ciò che serve per comunicare con le repositorie della JPA, controller -> interfaccia web (REST API, viste in genere).