INSERT INTO factors(id, name, status) VALUES
(1, 'Scrum', 'ACTIVE'),
(2, 'PP', 'ACTIVE'),
(3, 'Free Coffee', 'REMOVED'),
(4, 'Gym', 'ACTIVE');


INSERT INTO employees(id, first_name, last_name, manager_id) VALUES
(1, 'ManagerFN1', 'ManagerLN1', null),
(2, 'ManagerFN2', 'ManagerLN2', null),
(3, 'SpecialistFN3', 'SpecialistLN3', 1),
(4, 'SpecialistFN4', 'SpecialistLN4', 1),
(5, 'SpecialistFN5', 'SpecialistLN5', 1),
(6, 'SpecialistFN6', 'SpecialistLN6', 2),
(7, 'SpecialistFN7', 'SpecialistLN7', 2);


INSERT INTO results(id, emp_id, is_relevant, passing_datetime) VALUES
(1, 3, false, '2019-12-20 12:00'), -- spec 3
(2, 3, true, '2020-12-20 14:00'), -- spec 3

(3, 4, true, '2020-12-21 12:00'), -- spec 4
(4, 6, true, '2020-12-25 12:00'), -- spec 6

(5, 1, true, '2020-12-26 12:00'); -- manager 1


INSERT INTO estimation_pairs(id, result_id, factor_id, estim) VALUES
-- SPEC 3
-- survey was passed when 'free coffee' factor wasn't removed
(1, 1, 1, 'NEUTRAL'), (2, 1, 2, 'LIKE'), (3, 1, 3, 'LIKE'), (4, 1, 4, 'NOT_LIKE'),
-- 'free coffee' factor already was removed
(5, 2, 1, 'NOT_LIKE'), (6, 2, 2, 'NEUTRAL'), (7, 2, 4, 'LIKE'),
---------------------------------

(8, 3, 1, 'NEUTRAL'), (9, 3, 2, 'LIKE'), (10, 3, 4, 'NOT_LIKE'), -- spec 4
(11, 4, 1, 'NEUTRAL'), (12, 4, 2, 'LIKE'), (13, 4, 4, 'NOT_LIKE'), -- spec 6
------------------------------

-- manager 1
(14, 5, 1, 'LIKE'), (15, 5, 2, 'NEUTRAL'), (16, 5, 4, 'LIKE');
