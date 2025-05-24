INSERT INTO box (name) VALUES
                           ('Box A'),
                           ('Box B'),
                           ('Box C');

INSERT INTO grape (description, title) VALUES
                                           ('Red and sweet', 'Cabernet Sauvignon'),
                                           ('Green and tart', 'Sauvignon Blanc'),
                                           ('Purple and juicy', 'Merlot');


INSERT INTO region (country, description, name) VALUES
                                                    ('France', 'Famous wine region', 'Bordeaux'),
                                                    ('Italy', 'Historic vineyards', 'Tuscany'),
                                                    ('USA', 'Popular for various wines', 'Napa Valley');

INSERT INTO wine (title, type, year, region_id, wine_id) VALUES
                                                             ('Chateau Margaux', 'Red', 2019, 1, 1),
                                                             ('Sassicaia', 'Red', 2018, 2, 2),
                                                             ('Opus One', 'Red', 2020, 3, 3);

INSERT INTO wine_grapes (wines_id, grapes_id) VALUES
                                                  (1, 1),
                                                  (1, 3),
                                                  (2, 1),
                                                  (2, 2),
                                                  (3, 1),
                                                  (3, 2),
                                                  (3, 3);


