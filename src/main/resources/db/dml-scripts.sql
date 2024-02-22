INSERT INTO PRODUCT(PRODUCT_ID, NAME, PRICE, AMOUNT, DESCRIPTION, IMAGE)
VALUES ('260f7043-d0bf-4d99-b143-6ee555685561', 'Meta Quest 2', 299.99, 1000, 'Experience the power of VR. Discover new adventures, master epic challenges or revisit classic moments in your favorite games and experiences. Explore VR on a platform you can trust, with enhanced privacy features that encrypt your data and supervision tools that keep content friendly for everyone in the family.', 'quest2.webp'),
       ('260f7043-d0bf-4d99-b143-6ee555685560', 'Meta Quest 3 (128 GB)', 549.99, 500, 'Meta Quest 3 features breakthrough mixed reality that enables a spectrum of immersive experiences, like playing a virtual piano on your coffee table. The headset features a 30% leap in visual resolution and 40% louder audio range than Quest 2 – it’s also thinner with a more balanced weight distribution than Quest 2 for maximum comfort.', 'quest3.png'),
       ('260f7043-d0bf-4d99-b143-6ee555685573', 'Meta Quest 3 (512 GB)', 699.99, 150, 'Meta Quest 3 features breakthrough mixed reality that enables a spectrum of immersive experiences, like playing a virtual piano on your coffee table. The headset features a 30% leap in visual resolution and 40% louder audio range than Quest 2 – it’s also thinner with a more balanced weight distribution than Quest 2 for maximum comfort.', 'quest3.png'),
       ('260f7043-d0bf-4d99-b143-6ee555685562', 'Apple Vision Pro', 3999.99, 100, 'Apple Vision Pro is Apple''s first spatial computer. It seamlessly blends digital content with your physical space using revolutionary technology.', 'visionpro.jpg'),
       ('260f7043-d0bf-4d99-b143-6ee555685563', 'Bigscreen Beyond', 999.99, 200, 'The world''s smallest VR headset. Featuring OLED microdisplays with 2560 x 2560 pixels per eye, custom pancake optics, and SteamVR tracking – all in an unbelievably small form factor weighing just 127 grams.', 'bigscreenbeyond.jpg'),
       ('260f7043-d0bf-4d99-b143-6ee555685564', 'Varjo XR-4', 3999.99, 150, 'Varjo’s new generation of headsets connects the world’s most advanced mixed reality technology with the pinnacle of graphical processing power, catering to industrial use cases where highest-level visual fidelity and immersion are critical.', 'varjoxr4.jpg'),
       ('260f7043-d0bf-4d99-b143-6ee555685565', 'HP Reverb G2', 599.99, 300, 'The no-compromise VR headset. Realistic visuals. Immersive soundscapes. Superb tracking and performance. Developed in collaboration with Valve and Microsoft, this breakthrough headset delivers a more immersive experience. Ergonomically designed for comfort. Optimized for compatibility. Introducing the new standard in VR.', 'hpreverbg2.webp'),
       ('260f7043-d0bf-4d99-b143-6ee555685566', 'Valve Index', 1099.99, 200, 'With fidelity as a priority, the Valve Index Headset delivers on all fronts. Featuring a custom double element design and canted in position, our lenses maximize field of view without sacrificing edge-to-edge clarity.', 'valveindex.jpg'),
       ('260f7043-d0bf-4d99-b143-6ee555685567', 'Weart TouchDIVER', 4499.99, 20, 'TouchDIVER is an innovative haptic glove that enables lifelike interaction in VR, AR, and MR by offering comprehensive haptic feedback, including force, textures, and temperature sensations. It features precise sensors to track hand and finger movements, enabling natural interactions with virtual elements and surroundings.', 'wearttouchdiver.jpg'),
       ('260f7043-d0bf-4d99-b143-6ee555685568', 'Varjo Face Cushions', 149.0, 40, 'Easily replaceable face cushions. The cushions are easy to clean after use and provide a hygienic experience when multiple persons share a headset. One size fits all, with soft padding to accommodate different head shapes.', 'varjofacecushions.webp'),
       ('260f7043-d0bf-4d99-b143-6ee555685569', 'Meta Quest 3 Facial Interface', 39.99, 200, 'Keep your Meta Quest 3 headset clean and comfortable with this soft, silicone facial interface. Easily wipe away sweat and dirt from your Meta Quest 3 with this soft and comfortable silicone facial interface that feels gentle against your skin.', 'quest3facialinterface.jpg'),
       ('260f7043-d0bf-4d99-b143-6ee555685570', 'Meta Quest 3 Elite Strap', 69.99, 100, 'Play in comfort with this ergonomic strap that easily adjusts to most head sizes with the turn of a dial.', 'quest3elitestrap.webp'),
       ('260f7043-d0bf-4d99-b143-6ee555685571', 'Meta Quest 3 Elite Strap with Battery', 129.99, 50, 'Play in comfort and get up to 2 hours additional VR game play time with this ergonomic, adjustable head strap that features a built-in battery pack.', 'quest3elitestrap.webp'),
       ('260f7043-d0bf-4d99-b143-6ee555685572', 'Meta Quest 2 Elite Strap', 49.99, 200, 'Add a new level of comfort to your game. This ergonomic strap increases balance and support with a twist of the fit wheel, so you can keep your head in the game no matter what comes your way.', 'quest2elitestrap.jpg');

insert into PRODUCT_CATEGORY(NAME)
VALUES ('VR/AR Headset'),
       ('Haptic devices'),
       ('Face cushions'),
       ('Headstraps'),
       ('Headstrapsasd');

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