BEGIN;

INSERT INTO public.activity(
    id, location, number_of_people, "time", type_of_sport_activity)
VALUES ('1b2a795e-e5f3-468d-a05c-15a535adb511', 'Wöhrmühle 6, 91056 Erlangen', 10, '2023-11-22 16:47:35.92992', 1);

INSERT INTO public.activity(
    id, location, number_of_people, "time", type_of_sport_activity)
VALUES ('5c70e990-3fc4-4223-83ee-69f4f101469b', 'Komotauer Str. 1, 91052 Erlangen', 22, '2023-11-20 17:47:35.92992', 0);

INSERT INTO public.activity(
    id, location, number_of_people, "time", type_of_sport_activity)
VALUES ('45b85de0-ab5a-4bf2-b76d-fc26c61b6c12', 'Bürgermeistersteg 1, 91054 Erlangen', 4, '2023-11-03 15:47:35.92992', 2);

INSERT INTO public.activity(
    id, location, number_of_people, "time", type_of_sport_activity)
VALUES ('e6dff13a-5822-4e8b-90d0-ec6dc77840fa', 'Bürgermeistersteg 1, 91054 Erlangen', 10, '2023-11-03 14:47:35.92992', 1);

INSERT INTO public.activity(
    id, location, number_of_people, "time", type_of_sport_activity)
VALUES ('fee6b0bb-4b60-4e96-ab79-17064ae18bcc', 'Kurt-Schumacher-Straße 11, 91052 Erlangen', 22, '2023-11-03 14:47:35.92992', 0);

COMMIT;