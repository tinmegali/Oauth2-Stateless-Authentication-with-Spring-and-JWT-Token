<p>
<strong>TODO</strong><br/>
<li>Create some restricted resources
<li>Add users on Database
<li>Remove users ad invalidate JWT tokens
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
</div>