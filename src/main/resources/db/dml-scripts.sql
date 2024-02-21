INSERT INTO PRODUCT(PRODUCT_ID, NAME, PRICE, AMOUNT)
VALUES ('260f7043-d0bf-4d99-b143-6ee555685561', 'Meta Quest 2', 299.99, 1000),
       ('260f7043-d0bf-4d99-b143-6ee555685560', 'Meta Quest 3 (128 GB)', 549.99, 500),
       ('260f7043-d0bf-4d99-b143-6ee555685573', 'Meta Quest 3 (512 GB)', 699.99, 150),
       ('260f7043-d0bf-4d99-b143-6ee555685562', 'Apple Vision Pro', 3999.99, 100),
       ('260f7043-d0bf-4d99-b143-6ee555685563', 'Bigscreen Beyond', 999.99, 200),
       ('260f7043-d0bf-4d99-b143-6ee555685564', 'Varjo XR-4', 3999.99, 150),
       ('260f7043-d0bf-4d99-b143-6ee555685565', 'HP Reverb G2', 399.99, 300),
       ('260f7043-d0bf-4d99-b143-6ee555685566', 'Valve Index', 1099.99, 200),
       ('260f7043-d0bf-4d99-b143-6ee555685567', 'Weart TouchDIVER', 4499.99, 20),
       ('260f7043-d0bf-4d99-b143-6ee555685568', 'Varjo Face Cushions', 149.0, 40),
       ('260f7043-d0bf-4d99-b143-6ee555685569', 'AMVR Meta Quest 3 Silicone Facial Interface', 12.99, 200),
       ('260f7043-d0bf-4d99-b143-6ee555685570', 'Meta Quest 3 Elite Strap', 69.99, 100),
       ('260f7043-d0bf-4d99-b143-6ee555685571', 'Meta Quest 3 Elite Strap with Battery', 129.99, 50),
       ('260f7043-d0bf-4d99-b143-6ee555685572', 'Meta Quest 2 Elite Strap', 49.99, 200);

insert into PRODUCT_CATEGORY(NAME)
VALUES ('VR/AR Headset'),
       ('Haptic devices'),
       ('Face cushions'),
       ('Headstraps');

insert into PRODUCT_PRODUCT_CATEGORIES(product_id, product_categories_id)
VALUES (1, 2),
       (2, 1);

INSERT INTO users(name, surname, email, password, zip_code, phone_number)
    VALUES ('Admin', 'Admin', 'admin@eshop.lt', '$2a$10$RaoyLY5ZVehcXsqk65jKcexHb/LLXkvjQfILcF/oo8lPJBjeO001m', 'LT-0001', '+37061234567'),
            ('User', 'User', 'user@eshop.lt', '$2a$10$RaoyLY5ZVehcXsqk65jKcexHb/LLXkvjQfILcF/oo8lPJBjeO001m', 'LT-0002', '+37061234568');

INSERT INTO authority(name, description)
VALUES ('ADMIN', NULL),
       ('USER', 'User with limited rights');

INSERT INTO users_authorities(user_id, authorities_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);