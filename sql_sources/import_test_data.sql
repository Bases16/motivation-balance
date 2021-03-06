INSERT INTO factors(id, name, status) VALUES
(1, 'Scrum', 'ACTIVE'),
(2, 'PP', 'ACTIVE'),
(3, 'Free Coffee', 'REMOVED'),
(4, 'Gym', 'ACTIVE');


INSERT INTO employees(id, first_name, last_name, emp_role, manager_id) VALUES
(1, 'ManagerFN1', 'ManagerLN1', 'MANAGER', null),
(2, 'ManagerFN2', 'ManagerLN2', 'MANAGER', null),
(3, 'SpecialistFN3', 'SpecialistLN3', 'SPECIALIST', 1),
(4, 'SpecialistFN4', 'SpecialistLN4', 'SPECIALIST', 1),
(5, 'SpecialistFN5', 'SpecialistLN5', 'SPECIALIST', 1),
(6, 'SpecialistFN6', 'SpecialistLN6', 'SPECIALIST', 2),
(7, 'BannedSpecFN7', 'BannedSpecLN7', 'SPECIALIST', 2);
-- (8, 'ManagerFN3', 'ManagerLN3', 'MANAGER', null),
-- (9, 'ManagerFN4', 'ManagerLN4', 'MANAGER', null),
-- (10, 'SpecialistFN7', 'SpecialistLN7', 'SPECIALIST', null),
-- (11, 'SpecialistFN8', 'SpecialistLN8', 'SPECIALIST', null);

INSERT INTO users(id, emp_id, email, password, role, status) VALUES
(998, null, 'admin@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'ADMIN', 'ACTIVE'),
(1, 1, 'manag1@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'MANAGER', 'ACTIVE'),
(2, 2, 'manag2@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'MANAGER', 'ACTIVE'),
(3, 3, 'spec3@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'SPECIALIST', 'ACTIVE'),
(4, 4, 'spec4@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'SPECIALIST', 'ACTIVE'),
(5, 5, 'spec5@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'SPECIALIST', 'ACTIVE'),
(6, 6, 'spec6@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'SPECIALIST', 'ACTIVE'),
(7, 7, 'bannedSpec7@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'SPECIALIST', 'BANNED');
-- (8, 8, 'manag3@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'MANAGER', 'ACTIVE'),
-- (9, 9, 'manag4@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'MANAGER', 'ACTIVE'),
-- (10, 10, 'spec7@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'SPECIALIST', 'ACTIVE'),
-- (11, 11, 'spec8@test.com', '$2y$12$RIzX.iFE9xhwTKyySjFB7O5RkCRwTA.Fs0RNvZX59DNIu9XjqX24G', 'SPECIALIST', 'ACTIVE');


INSERT INTO results(id, emp_id, is_relevant, pass_datetime) VALUES
(1, 3, false, '2019-12-20 12:00+03'), -- spec 3
(2, 3, true, '2020-12-20 14:00+03'), -- spec 3

(3, 4, true, '2020-12-21 12:00+03'), -- spec 4
(4, 6, true, '2020-12-25 12:00+03'), -- spec 6

(5, 1, true, '2020-12-26 12:00+03'); -- manager 1


INSERT INTO estimation_pairs(id, result_id, factor_id, estim) VALUES
-- SPEC 3
-- survey was passed when 'free coffee' factor wasn't removed
(1, 1, 1, 'NEUTRAL'), (2, 1, 2, 'LIKE'), (3, 1, 3, 'LIKE'), (4, 1, 4, 'DISLIKE'),
-- 'free coffee' factor already was removed
(5, 2, 1, 'DISLIKE'), (6, 2, 2, 'NEUTRAL'), (7, 2, 4, 'LIKE'),
---------------------------------

(8, 3, 1, 'NEUTRAL'), (9, 3, 2, 'LIKE'), (10, 3, 4, 'DISLIKE'), -- spec 4
(11, 4, 1, 'NEUTRAL'), (12, 4, 2, 'LIKE'), (13, 4, 4, 'DISLIKE'), -- spec 6
------------------------------

-- manager 1
(14, 5, 1, 'LIKE'), (15, 5, 2, 'NEUTRAL'), (16, 5, 4, 'LIKE');
