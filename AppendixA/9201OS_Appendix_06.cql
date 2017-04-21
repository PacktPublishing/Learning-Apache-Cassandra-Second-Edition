UPDATE "user_status_updates"
SET "shared_by" = "shared_by" + ['bob'],
    "shared_by" = ['dave'] + "shared_by"
WHERE "username" = 'alice'
AND "id" = 76e7a4d0-e796-11e3-90ce-5f98e903bf02;
