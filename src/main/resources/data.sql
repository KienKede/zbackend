insert into provider (provider_uuid, provider_name, creation_datetime) values('e99b80fa-9a1b-446b-aa4f-44eca3d75676', 'Poker Star', sysdate());
insert into provider (provider_uuid, provider_name, creation_datetime) values('88fcf169-4bc5-46df-b9a5-07c3ef83f06e', 'BWIN', sysdate());

insert into player (player_uuid, balance, creation_datetime, player_name, time_left, provider_uuid, deleted) values('76469355-682a-40b4-8807-ec3269a111a8', 40, sysdate(), 'Mariano', 22, 'e99b80fa-9a1b-446b-aa4f-44eca3d75676', false);
insert into player (player_uuid, balance, creation_datetime, player_name, time_left, provider_uuid, deleted) values('b4d3400a-14ba-4846-9b47-5fbb4bba9c3d', 100, sysdate(), 'Paco_63', 25, 'e99b80fa-9a1b-446b-aa4f-44eca3d75676', false);
insert into player (player_uuid, balance, creation_datetime, player_name, time_left, provider_uuid, deleted) values('db5636a8-89e2-4be3-844c-2e661089ef59', 90, sysdate(), 'Sonata', 24, '88fcf169-4bc5-46df-b9a5-07c3ef83f06e', false);

insert into kind_of_game (kind_of_game_id, kind_of_game_name) values (1, 'VIDEOBINGO');
insert into kind_of_game (kind_of_game_id, kind_of_game_name) values (2, 'SLOT');
insert into kind_of_game (kind_of_game_id, kind_of_game_name) values (3, 'BLACKJACK');
insert into kind_of_game (kind_of_game_id, kind_of_game_name) values (4, 'POKER');
insert into kind_of_game (kind_of_game_id, kind_of_game_name) values (5, 'RULETA');

insert into game (game_id, game_name, kind_of_game_id, win_probabilities, win_amount) values (1, 'VideoBingo Amazonas', 1, 50, 1.5);
insert into game (game_id, game_name, kind_of_game_id, win_probabilities, win_amount) values (2, 'VideoBingo Piratas', 1, 70, 1.2);
insert into game (game_id, game_name, kind_of_game_id, win_probabilities, win_amount) values (3, 'Slot Normal', 2, 20, 2);
insert into game (game_id, game_name, kind_of_game_id, win_probabilities, win_amount) values (4, 'Blackjack Normal', 3, 25, 1.8);
insert into game (game_id, game_name, kind_of_game_id, win_probabilities, win_amount) values (5, 'Texas Hold’em ', 4, 12, 2.5);
insert into game (game_id, game_name, kind_of_game_id, win_probabilities, win_amount) values (6, 'Ruleta', 5, 22, 4);

insert into deposit (deposit_id, amount, deposited, player_uuid) values (1, 50, sysdate(), '76469355-682a-40b4-8807-ec3269a111a8');
insert into deposit (deposit_id, amount, deposited, player_uuid) values (2, 100, sysdate(), 'b4d3400a-14ba-4846-9b47-5fbb4bba9c3d');
insert into deposit (deposit_id, amount, deposited, player_uuid) values (3, 60, sysdate(), 'db5636a8-89e2-4be3-844c-2e661089ef59');

insert into play (play_id, amount_played, amount_won, played, game_id, player_uuid) values (1, 10, 0, sysdate(), 4, '76469355-682a-40b4-8807-ec3269a111a8');
insert into play (play_id, amount_played, amount_won, played, game_id, player_uuid) values (2, 10, 40, sysdate(), 6, 'db5636a8-89e2-4be3-844c-2e661089ef59');