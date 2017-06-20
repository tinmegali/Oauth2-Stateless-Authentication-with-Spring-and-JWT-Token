<p>
<strong>TODO</strong><br/>
<li>Remove users ad invalidate JWT tokens
<li>Register Account only for trusted clients
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
curl -X POST -H "Content-Type: application/json" -d '{"username":"tinmegali","password":"password","firstName":"First","lastName":"Last","email":"email@email.com"}' localhost:8080/api/register | jq
</code>
</p