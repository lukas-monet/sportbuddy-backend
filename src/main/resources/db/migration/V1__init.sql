BEGIN;

create table travel_plan
(
    id         bigserial                not null,
    created_at timestamp with time zone not null,
    user_id    uuid,
    city_id    uuid,
    start_date Date,
    end_date   Date,
    primary key (id)
);

COMMIT;