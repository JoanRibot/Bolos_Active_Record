DROP TABLE IF EXISTS t_ordenes;
DROP TABLE IF EXISTS t_users;
DROP TABLE IF EXISTS t_items;


CREATE TABLE t_users
(
    user_nom VARCHAR(255) NOT NULL UNIQUE,
    user_prop integer NOT NULL,
    PRIMARY KEY (user_nom)
) ENGINE = InnoDB;

CREATE TABLE t_items
(
    item_nom VARCHAR(255) NOT NULL UNIQUE,
    item_prop integer NOT NULL,
    item_tipo VARCHAR(255) NOT NULL,
    PRIMARY KEY (item_nom)
) ENGINE = InnoDB;

CREATE TABLE t_ordenes
(
    id BIGINT NOT NULL,
    ord_user VARCHAR(255) NOT NULL,
    ord_item VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_person_order`
    FOREIGN KEY (ord_user) REFERENCES t_users (user_nom),
    CONSTRAINT `fk_product_order`
    FOREIGN KEY (ord_item) REFERENCES t_items (item_nom)
) ENGINE = InnoDB;

INSERT INTO 
    t_users (user_nom, user_prop) 
VALUES
    ('Munson', 15),
    ('McCracken', 100);
INSERT INTO 
    t_items (item_nom,item_prop,item_tipo) 
VALUES 
    ('Murfreesboro Strike and Spare',20,'Torneo'),
    ('Bowlerama Lanes Iowa', 7,'Torneo');
INSERT INTO 
    t_ordenes (id,ord_user,ord_item) 
VALUES 
    (1, 'Munson', 'Bowlerama Lanes Iowa');