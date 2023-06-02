INSERT INTO role (name)
VALUES ('user');

INSERT INTO user (id, first_name, last_name, email_address, username, password, enabled)
VALUES ('1', 'James', 'Gosling', 'james@gosling.com', 'James123', 'goslings-password',
        '1');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO instructions (id, instructions)
VALUES (1, 'Start by making the sauce with ground beef, bell peppers, onions, and a combo of tomato sauce, tomato paste, and crushed tomatoes. The three kinds of tomatoes gives the sauce great depth of flavor.
Let this simmer while you boil the noodles and get the cheeses ready. We''re using ricotta, shredded mozzarella, and parmesan -- like the mix of tomatoes, this 3-cheese blend gives the lasagna great flavor!
From there, its just an assembly job. A cup of meat sauce, a layer of noodles, more sauce, followed by a layer of cheese. Repeat until you have three layers and have used up all the ingredients.
Bake until bubbly and you''re ready to eat!');

INSERT INTO RECIPE (id, name, cook_time, prep_time,total_time, ingredients, date_added, instructions_id)
VALUES (1, 'Lasagna', 5, 50, 25,

        '2 teaspoons extra virgin olive oil
        1 pound ground beef chuck
        1/2 medium onion, diced (about 3/4 cup)
        1/2 large bell pepper (green, red, or yellow), diced (about 3/4 cup)
        2 cloves garlic, minced
        1 (28-ounce)can good-quality tomato sauce
        3 ounces tomato paste (half a 6-ounce can)
        1 (14 ounce) can crushed tomatoes
        2 tablespoons chopped fresh oregano, or 2 teaspoons dried oregano
        1/4 cup chopped fresh parsley (preferably flat leaf), packed
        1 tablespoon Italian seasoning
        1 pinch garlic powder and/or garlic salt
        1 tablespoon red or white wine vinegar
        1 tablespoon to 1/4 cup sugar (to taste, optional)
        Salt',

        '2022-10-9', 1);


INSERT INTO users_recipes (user_id, recipe_id)
VALUES (1, 1);

INSERT INTO meal (id, date, name)
VALUES (1, '2022-10-9', 'Breakfast');

INSERT INTO meal_recipe (meal_id, recipe_id)
VALUES (1, 1);

INSERT INTO users_meals (meal_id, user_id)
VALUES (1, 1);


INSERT INTO event (id, name, event_date) VALUES
    ('1','Event 1','2022-10-9');

INSERT INTO user_event (event_id, user_id)
VALUES (1, 1);

INSERT INTO meal_event (event_id, meal_id)
VALUES (1, 1);