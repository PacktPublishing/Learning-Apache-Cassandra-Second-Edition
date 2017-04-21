CREATE USER 'data_analytics'
WITH PASSWORD 'strongpassword'
NOSUPERUSER;
ALTER USER 'data_analytics'
WITH PASSWORD 'verystrongpassword';
SELECT * FROM system_auth.users;
GRANT MODIFY PERMISSION
ON TABLE "my_status"."status_update_views"
TO 'data_analytics';
SELECT * FROM "system_auth"."permissions";
REVOKE MODIFY PERMISSION
ON "my_status"."status_update_views"
FROM 'data_analytics';
DELETE FROM "users"
WHERE "username" = 'alice';
