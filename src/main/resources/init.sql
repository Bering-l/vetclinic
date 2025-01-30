CREATE TABLE addresses (
    address_id SERIAL PRIMARY KEY,
    region VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    city VARCHAR(100),
    street VARCHAR(255) NOT NULL,
    house INT NOT NULL,
    building INT,
    flat INT
);

CREATE TABLE breeders (
    breeder_id SERIAL PRIMARY KEY,
    name_club CHAR(100) NOT NULL,
    rkf_number INT UNIQUE
);

CREATE TABLE breeds (
    breed_id SERIAL PRIMARY KEY,
    breed_name VARCHAR(255) NOT NULL
);

CREATE TABLE colors (
    color_id SERIAL PRIMARY KEY,
    color_name VARCHAR(255) NOT NULL
);


CREATE TABLE breed_colors (
    breed_id INT NOT NULL,
    color_id INT NOT NULL,
    PRIMARY KEY (breed_id, color_id),
    FOREIGN KEY (breed_id) REFERENCES breeds(breed_id) ON DELETE CASCADE,
    FOREIGN KEY (color_id) REFERENCES colors(color_id) ON DELETE CASCADE
);

CREATE TYPE species AS ENUM('dog', 'cat', 'other');

CREATE TABLE animals (
    animal_id SERIAL PRIMARY KEY,
    breed_id INT,
    FOREIGN KEY (breed_id) REFERENCES breeds(breed_id),
    type species NOT NULL,
    animal_name VARCHAR(150) NOT NULL,
    gender VARCHAR(1) NOT NULL,
    description TEXT,
    date_of_birth DATE
);

CREATE TABLE pricelists (
    pricelist_id SERIAL PRIMARY KEY,
    procedure_name VARCHAR(150) NOT NULL,
    price MONEY
);

CREATE TABLE procedures (
    procedures_id SERIAL PRIMARY KEY,
    pricelist_id INT,
    animal_id INT,
    FOREIGN KEY (pricelist_id) REFERENCES pricelists(pricelist_id),
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);

CREATE TABLE owners (
    owner_id SERIAL PRIMARY KEY,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id),
    owner_name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    telephone VARCHAR(15) NOT NULL,
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES addresses(address_id),
    is_breeders BOOLEAN DEFAULT false
);

CREATE TABLE breeders (
    breeder_id SERIAL PRIMARY KEY,
    name_club VARCHAR(100),
    rkf_number INT UNIQUE
) INHERITS (owners);

CREATE TABLE medical_records (
    medical_record_id SERIAL,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id),
    complaints TEXT,
    diagnosis TEXT,
    weight NUMERIC(6, 2),
    is_reproducible BOOLEAN DEFAULT true
);

CREATE TABLE vaccinations (
    vaccination_id SERIAL,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id),
    vaccination_type VARCHAR(160),
    vaccine_used VARCHAR(50),
    batch_number VARCHAR(50),
    vaccination_date DATE,
    valid_until DATE
);

CREATE TABLE identifications (
    identification_id SERIAL,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES animals(animal_id),
    date_of_microchipping DATE,
    location_microchip VARCHAR(120),
    tattoo_number INT,
    date_of_tattooing DATE,
    pedigree_number INT
);