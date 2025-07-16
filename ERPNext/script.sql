CREATE TABLE tab_pourcentage_deduction_salaire (
    id_pds INT AUTO_INCREMENT PRIMARY KEY,
    mois VARCHAR(20),
    valeur DECIMAL(15,2)
);

CREATE TABLE historique_salary_slip (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    employee_name VARCHAR(100),
    salary_structure VARCHAR(100),
    start_date VARCHAR(20),
    end_date VARCHAR(20),
    salaire_de_base VARCHAR(20)
);


INSERT INTO tab_pourcentage_deduction_salaire (mois, valeur) VALUES 
('Janvier', 10),
('Février', 15),
('Mars', 20),
('Avril', 30),
('Mai', 15),
('Juin', 25),
('Juillet', 10),
('Août', 10),
('Septembre', 20),
('Octobre', 25),
('Novembre', 15),
('Décembre', 35);