# List<Read> read(Map<String, String> params);
#     Mappa => {
#         "name" : "hackjava",
#         "teacher_name": "Mirko",
#         "teacher_surname": "Abbrescia" 
#     }

#     //! query con mappa
#     String query = 'select ';

#     for(String key: params.keySet()){
#         query += key + ", "; //! name, teacher_name, teacher_surname
#     }
#     query += " from courses where ";

#     for(String key: params.keySet()){
#         query += key +  " = " +  params.get(key) + " AND "; //! name, teacher_name, teacher_surname
#     }

#     select name, teacher_name, teacher_surname from courses 
#         where name =hackjava 
#         AND teacher_name = Mirko
#         AND teacher_surname = Abbrescia

#     //! query su piu' colonne con lista
#     //! Corso : name, data, teacherFirstName
#     // List<Read> read(List<String> params);
#     // 'name', 'data', 'teacherFirstName', 'updated_at', 'altro campo 1' where name = pippo
#     // String query = "select " ;
#     // for(String param : params){
#     //     query += param + " ";
#     // }
#     //



Hibernate: alter table courses_students drop foreign key FKecu9b8uo86fy0wegale3gjtrw
Hibernate: alter table courses_students drop foreign key FKcj1bvqj437mdtgllmwcd41f2u
Hibernate: alter table lessons drop foreign key FK17ucc7gjfjddsyi0gvstkqeat

Hibernate: drop table if exists courses
Hibernate: drop table if exists courses_students
Hibernate: drop table if exists lessons
Hibernate: drop table if exists students

Hibernate: create table courses (id bigint not null auto_increment, date DATE, description varchar(1000), name varchar(100) not null, teacher_firstname varchar(100) not null, teacher_lastname varchar(100) not null, primary key (id)) engine=InnoDB
Hibernate: create table courses_students (course_id bigint not null, student_id bigint not null) engine=InnoDB
Hibernate: create table lessons (id bigint not null auto_increment, date DATE DEFAULT (CURRENT_DATE), description varchar(1000), course_id bigint, primary key (id)) engine=InnoDB
Hibernate: create table students (id bigint not null auto_increment, data_firstname varchar(100) not null, data_lastname varchar(100) not null, email varchar(100) not null, primary key (id)) engine=InnoDB

Hibernate: alter table students add constraint UK_e2rndfrsx22acpq2ty1caeuyw unique (email)
Hibernate: alter table courses_students add constraint FKecu9b8uo86fy0wegale3gjtrw foreign key (student_id) references students (id)
Hibernate: alter table courses_students add constraint FKcj1bvqj437mdtgllmwcd41f2u foreign key (course_id) references courses (id)
Hibernate: alter table lessons add constraint FK17ucc7gjfjddsyi0gvstkqeat foreign key (course_id) references courses (id)


//generationType non IDENTITY non riesce a mappare auto_increment come strategia