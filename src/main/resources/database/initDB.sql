CREATE TABLE IF NOT EXISTS services(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(300) NOT NULL,
    description NVARCHAR(1000) NOT NULL,
    image_link NVARCHAR(1000) NOT NULL,
    show_all Boolean
);

CREATE TABLE IF NOT EXISTS service_sample_link(
    id INT AUTO_INCREMENT PRIMARY KEY,
    service_id INT NOT NULL,
    link_url NVARCHAR(1000) NOT NULL,
    FOREIGN KEY (service_id) REFERENCES services(id)
);

CREATE TABLE IF NOT EXISTS contact_persons(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    position VARCHAR(128) NOT NULL,
    mail VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS contact_phones(
    id INT AUTO_INCREMENT PRIMARY KEY,
    contact_id INT NOT NULL,
    phone VARCHAR(20) NOT NULL,
    FOREIGN KEY (contact_id) REFERENCES contact_persons(id)
);

CREATE TABLE IF NOT EXISTS vacancies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    contact_id INT NOT NULL,
    name VARCHAR(300) NOT NULL,
    description NVARCHAR(1000),
    show_all Boolean,
    FOREIGN KEY (contact_id) REFERENCES contact_persons(id)
);

CREATE TABLE IF NOT EXISTS products(
    id INT AUTO_INCREMENT PRIMARY KEY,
    description NVARCHAR(1000) NOT NULL,
    platform_link_to_store NVARCHAR(1000) NOT NULL,
    icon_link nVARCHAR(300) NOT NULL,
    show_all Boolean

);

CREATE TABLE IF NOT EXISTS screenshots(
          id INT AUTO_INCREMENT PRIMARY KEY,
          product_id INT NOT NULL,
          image_link NVARCHAR(100) NOT NULL,
          FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE IF NOT EXISTS customers(
           id INT AUTO_INCREMENT PRIMARY KEY,
           product_id INT NOT NULL,
           name VARCHAR(300) NOT NULL,
           site_link NVARCHAR(300) NOT NULL,
           person_name VARCHAR(300),
           person_linked_in NVARCHAR(300),
           person_recommendation NVARCHAR(300),
           customer_challenge NVARCHAR(1000) NOT NULL,
           five_solution NVARCHAR(1000) NOT NULL,
           show_all Boolean,
           FOREIGN KEY (product_id) REFERENCES products(id)

);

CREATE TABLE IF NOT EXISTS technologies(
            id INT AUTO_INCREMENT PRIMARY KEY,
            technology VARCHAR(100) NOT NULL

);

CREATE TABLE IF NOT EXISTS customers_technologies(
             customer_id INT NOT NULL,
             technology_id INT NOT NULL,
             FOREIGN KEY (customer_id) REFERENCES customers(id),
             FOREIGN KEY (technology_id) REFERENCES technologies(id)
);

CREATE TABLE IF NOT EXISTS mainpage_counters(
             id INT AUTO_INCREMENT PRIMARY KEY,
             counter_services INT NOT NULL,
             counter_products INT NOT NULL,
             counter_customers INT NOT NULL,
             counter_vacancies INT NOT NULL

)
