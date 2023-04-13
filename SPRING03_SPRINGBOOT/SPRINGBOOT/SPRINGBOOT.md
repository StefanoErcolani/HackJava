-Alternativa a Java Enterprise. Si usa maven come build tools ma non si avvia tramite maven.

1. Spring initializer: create a Maven Project ->  progetto preconfigurato ( tutto: sistemi, drivers, connettori, dipendenze, etc, in modo che sia tutto coerente). 
-Package type -> jar ( vari tipi per eseguibile di due tipi, ovvero jar e war [primo eseguibile, secondo deployabile -in SpringBoot Tomcat-]). 
-Scelta dependecies:
    -- 0 dependencies ( avvia il web server e rimane vuoto). 
    --Invece,  Web tools -poter sviluppare un progetto come LiveReload[caricare istantaneamente le modifiche al progetto come live server su vscode]-
    --Selezione SpringData: invece della dependecy che comunica direttamente col jdbc ( dover costruire i dao e scrivere manualmente le queries) selezionare Spring JPA.
    [L'example viene scaricato dalla rete -> start.spring.io].

2. Spring boot projecy structure: il main non verrà toccato MAI.
-Le dependencies derivano da un parent, una pre-configurazione sempre di maven ( aèrire il pom tramite java projects). Su questa inizializzazione necessaria aggiunta di dependency java connector.
-Application properties inserire stringa di collegamento al db tramite jdbc -url,username,password-(essendo tutte stringhe properties non servono le virgolette e NON inserire spazi -chiave=valore-).

3. TestSpringBoot:
SI TESTA LA PERSISTENZA DEI DATI NEI DB SENZA EFFETTIVAMENTE ALTERARLI AL DI FUORI DEL TEST STESSO.

@SpringBootTest effettua un test su tutto il web server;

@DataJpaTest e @AutoConfigureTestDatabase si occupano solo di creare un ambiente di prova per ciò che è inerente alla JPA (la seconda annotation serve per configurazione).

@Entity notation per specificare per la JPA una tabella che sarà un'entità o un model. 
@Table(name="") notation che serve insieme ad entity per specificare quale tabella si riferisca all'entità. Le due entità sono SINCRONIZZATE: per questo aggiungere ai vari campi un notation; caso particolare l'id auto incrementato ->
@Id
@GeneretedValue(strategy = GenerationType.IDENTITY) -varia in base al jpa dialect-

In test per controllare qualcosa come id si usa un'entità che deriva da Jpa, l'entityManager ( obv collegato tramite bean Autowired).
Metodi EntityManager (under @Test)(molto più comodo manipolare un oggetto alla volta ( qua si lavora con gli oggeti biatch) ):


IsPersisten?
.persist() salva un oggetto -> per testare crearne uno nuovo (new e setter), lanciare persist e poi per controllare qualcosa che avviene senza intervenire effettivamente sul db

DA QUERY class -> .createNativeQuery(sqlString->"") il tipo deriva dai sottolinguaggi vari di sql, crea una queery select; 

DA TypedQuery -> .createQuery(sqlString, dataType) che permette di creare una lista di tutti gli elementi senza casting ( check sul valore ritornato dal size della lista) -> richiede un metalinguaggio sequel ( non usare asterisco ma un alias, il sostituto di all è solo l'alias)

.getResultList() crea una lista del prodotto ( necessario casting con le native query).

Assertion.assertThat(listName).hasSize(int expected); -> da

canIUpdate?
TypedQuery List -> SELECT; -> getResultList(); -> .get(); -> set element of the same type of the fields -> .persist() -> new List.getResultList -> .get() ->Assertions on that list element variable.extracting("fieldname").isEqualTo(nomeelementosettatosestringa)