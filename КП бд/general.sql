CREATE TABLE users(
  user_login varchar(150) NOT NULL,
  user_password varchar(150) NOT NULL,
  user_role varchar(150) NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY (user_login)
);

CREATE TABLE customers
(
  ID serial NOT NULL,
  snp varchar(150) NOT NULL,
  OGRN varchar(150) NOT NULL,
  INN varchar(150) NOT NULL,
  firmtitle varchar(150) NOT NULL,
  city varchar(150) NOT NULL,
  phone varchar(150) NOT NULL,
  email varchar(150) NOT NULL,
  login VARCHAR (150) NOT NULL,
  CONSTRAINT customers_pk PRIMARY KEY (ID),
  CONSTRAINT user_customer_fk FOREIGN KEY (login) REFERENCES users (user_login)
);
CREATE TABLE suppliers
(
  ID serial NOT NULL,
  OGRN varchar(150) NOT NULL,
  INN varchar(150) NOT NULL,
  firmtitle varchar(150) NOT NULL,
  snp_director varchar(150) NOT NULL,
  contract_validity int NOT NULL,
  contract_sign_date date NOT NULL,
  CONSTRAINT suppliers_pk PRIMARY KEY (ID)
);
CREATE TABLE toy_types
(
  ID serial NOT NULL,
  toy_type varchar(150) NOT NULL,
  CONSTRAINT toy_types_pk PRIMARY KEY (ID)
);
--CREATE TYPE orderStateEnum AS ENUM ('Ожидает заказчика', 'Изготавливается', 'Поступил в очередь', 'Упаковывается');
CREATE TABLE orders
(
  ID serial NOT NULL,
  toy_title varchar(150) NOT NULL,
  order_cost money NOT NULL,
  currency varchar(150) NOT NULL,
  product_amount int NOT NULL,
  order_state varchar(150) NOT NULL,
  execution_date date,
  customer int NOT NULL,
CONSTRAINT order_pk PRIMARY KEY (ID),
CONSTRAINT orders_customers_fk FOREIGN KEY (customer) REFERENCES customers(ID)
);
CREATE TABLE equipment_types
(
  ID serial NOT NULL,
  equipment_type varchar(150) NOT NULL,
  CONSTRAINT equipment_type_pk PRIMARY KEY (ID)
);
CREATE TABLE equipment
(
  ID serial NOT NULL,
  title varchar(150),
  manufacture_date date,
  eq_function varchar(150),
  eq_type int NOT NULL,
  CONSTRAINT equipment_pk PRIMARY KEY (ID),
  CONSTRAINT equipment_equipment_types_fk FOREIGN KEY (eq_type) REFERENCES equipment_types(ID)
);
--CREATE TYPE institutionType AS ENUM ('Главный офис', 'Центральный магазин', 'Филиал', 'Магазин');
CREATE TABLE institutions
(
  ID serial NOT NULL,
  title varchar(150) NOT NULL,
  city varchar(150) NOT NULL,
  address varchar(150) NOT NULL,
  inst_type varchar(150) NOT NULL,
  phone varchar(150) NOT NULL,
  CONSTRAINT institution_pk PRIMARY KEY (ID)
);
CREATE TABLE departments
(
  ID serial NOT NULL,
  title varchar(150) NOT NULL,
  employee_count int NOT NULL,
  snp_chief varchar(150) NOT NULL,
  institution int NOT NULL,
  CONSTRAINT departments_pk PRIMARY KEY (ID),
  CONSTRAINT departments_institutions_fk FOREIGN KEY (institution) REFERENCES institutions (ID)
);
CREATE TABLE seats
(
  ID serial NOT NULL,
  seat varchar(150) NOT NULL,
  salary money NOT NULL,
  CONSTRAINT seats_pk PRIMARY KEY (ID)
);

CREATE TABLE employees
(
  ID serial NOT NULL,
  snp varchar(150) NOT NULL,
  birthdate date NOT NULL,
  city varchar(150),
  address varchar(150),
  phone varchar(150) NOT NULL,
  seat int NOT NULL,
  department int NOT NULL,
  institution int NOT NULL,
  login VARCHAR(150) NOT NULL,
  CONSTRAINT employees_pk PRIMARY KEY (ID),
  CONSTRAINT employee_seat_fk FOREIGN KEY (seat) REFERENCES seats(ID),
  CONSTRAINT employee_department_fk FOREIGN KEY (department) REFERENCES departments(ID),
  CONSTRAINT employee_institution_fk FOREIGN KEY (institution) REFERENCES institutions(ID),
  CONSTRAINT employee_user_fk FOREIGN KEY (login) REFERENCES users (user_login)
);
CREATE TABLE materials
(
  ID serial NOT NULL,
  material varchar(150) NOT NULL,
  CONSTRAINT materials_pk PRIMARY KEY (ID)
);
CREATE TABLE packages
(
  ID serial NOT NULL,
  length int NOT NULL,
  width int NOT NULL,
  height int NOT NULL,
  weight int NOT NULL,
  material int NOT NULL,
  CONSTRAINT packages_pk PRIMARY KEY (ID),
  CONSTRAINT packages_materials_fk FOREIGN KEY (material) REFERENCES materials (ID)
);
CREATE TABLE toys(
  ID serial NOT NULL,
  barcode varchar(150) NOT NULL,
  title varchar(150) NOT NULL,
  produce_date date NULL,
  additional_info varchar(650),
  age_category varchar(150) NOT NULL,
  restrictions varchar(150) NULL,
  net_weight int NOT NULL,
  length int NOT NULL,
  width int NOT NULL,
  height int NOT NULL,
  gross_weight int NOT NULL,
  details_count int,
  toy_type int NOT NULL,
  institution int NOT NULL,
  material int NOT NULL,
  used_package int NOT NULL,
CONSTRAINT PK_Toy PRIMARY KEY (ID),
CONSTRAINT toys_ToyTypes_fk FOREIGN KEY (toy_type) REFERENCES toy_types(ID),
CONSTRAINT toys_Institutions_fk FOREIGN KEY (institution) REFERENCES institutions(ID),
CONSTRAINT toys_Materials_fk FOREIGN KEY (material) REFERENCES materials(ID),
CONSTRAINT toys_Packages_fk FOREIGN KEY (used_package) REFERENCES packages(ID)
);

CREATE TABLE toy_produce
(
  employee int NOT NULL,
  toy int NOT NULL,
  equipment int NOT NULL,
  current_order int NOT NULL,
  material_count int NOT NULL,
  CONSTRAINT toy_produce_pk PRIMARY KEY (employee,toy,equipment,current_order),
  CONSTRAINT toy_produce_employees_fk FOREIGN KEY (employee) REFERENCES employees(ID),
  CONSTRAINT toy_produce_toys_fk FOREIGN KEY (toy) REFERENCES toys(ID),
  CONSTRAINT toy_produce_orders_fk FOREIGN KEY (current_order) REFERENCES orders(ID),
  CONSTRAINT toy_produce_equipment_fk FOREIGN KEY (equipment) REFERENCES equipment(ID)
);
CREATE TABLE public.package_fabricate
(
  employee integer NOT NULL,
  equipment integer NOT NULL,
  current_package integer NOT NULL,
  material_amount integer NOT NULL,
  CONSTRAINT package_fabricate_pk PRIMARY KEY (employee, equipment, current_package),
  CONSTRAINT package_fabricate_employees_fk FOREIGN KEY (employee)
      REFERENCES public.employees (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT package_fabricate_equipment_fk FOREIGN KEY (equipment)
      REFERENCES public.equipment (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT package_fabricate_packages_fk FOREIGN KEY (current_package)
      REFERENCES public.packages (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE procurements
(
  ID serial NOT NULL,
  procurement_date date NOT NULL,
  material_count int NOT NULL,
  supplier int NOT NULL,
  material int NOT NULL,
  CONSTRAINT procurements_pk PRIMARY KEY (ID),
  CONSTRAINT procurements_Materials_fk FOREIGN KEY (material) REFERENCES materials (ID),
  CONSTRAINT procurements_Suppliers_fk FOREIGN KEY (supplier) REFERENCES suppliers(ID)
);
--CREATE TYPE role_type AS ENUM ('Покупатель','Сотрудник','Администратор');










