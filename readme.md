<p>
<strong>TODO</strong><br/>
<li>Remove users ad invalidate JWT tokens
<li>Write all the basic tests
<li>Turn all debug options 'on'
</p>

<div>
To get a new token <br/>
<code>
curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=password&username=user&password=password" | jq
</code>

<br/>
To get a refresh token<br/>
<code>
curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=access_token&access_tokem=[ACCESS_TOKEN]" | jq
</code>


<br/>
To access a protected resource<br/>
<code>
curl -H "Authorization: Bearer [ACCESS_TOKEN]" localhost:8080/api/hello
</code>
</div>

<p>
<strong>Register new Account</strong><br/>
<code>
curl -H "Authorization: Bearer $(curl register-app:secret@localhost:8080/oauth/token -d "grant_type=client_credentials&client_id=register-app" | jq --raw-output ."access_token")" localhost:8080/api/register -H "Content-Type: application/json" -d '{"username":"new-user","password":"password","firstName":"First","lastName":"Last","email":"email@email.com"}' | jq
</code>
</p>

<div>
<p>
<strong>Curl sample commands</strong>
<em>api/me</em>
<code>curl -H "Authorization: Bearer $(curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=password&username=user&password=password" | jq --raw-output ."access_token")" localhost:8080/api/me | jq</code>
</p>
</div>