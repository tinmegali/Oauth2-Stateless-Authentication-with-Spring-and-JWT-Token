<h1>
Oauth2 Stateless Authentication with Spring and JWT Token
</h1>
<p>
This project uses <em>Spring Security</em> to authenticate and protect some Rest resources.
 It uses <code>withAuthorizationServerConfigurerAdapter</code>, <code>ResourceServerConfigurerAdapter</code>
  and <code>WebSecurityConfigurerAdapter</code> combined with <code>@PreAuthorize</code> to configure the security.
  It also uses an <em>H2 embeded database</em> to authenticate the users.
</p>

<h4>Article on the project</h4>
<a href="http://www.tinmegali.com/en/2017/06/25/oauth2-using-spring/">USING SPRING OAUTH2 TO SECURE REST</a>

<h4>External references</h4>
This project was inspired by all these references.
<li> <a href="http://www.baeldung.com/spring-security-oauth-jwt">Using JWT with Spring Security OAuth</a>
<li> <a href="https://sdqali.in/blog/2016/07/13/jwt-authentication-with-spring-web---part-5/">JWT authentication with Spring Web</a>
<li> <a href="http://www.svlada.com/jwt-token-authentication-with-spring-boot/#jwt-authentication">JWT Authentication Tutorial: An example using Spring Boot</a>
<li> <a href="http://sgdev-blog.blogspot.com.br/2016/04/spring-oauth2-with-jwt-sample.html">Spring Oauth2 with JWT Sample</a>
<li> <a href="http://www.swisspush.org/security/2016/10/17/oauth2-in-depth-introduction-for-enterprises">OAuth2 in depth: A step-by-step introduction for enterprises</a>
<li> <a href="https://github.com/gdong42/spring-auth-example">spring-auth-example</a>

<h4>To Build and Run</h4>
Go to the cloned directory and run <code>mvn spring-boot:run</code> or build with your chosen IDE.

<h4>Curl Commands</h4>
You should install <a href="https://stedolan.github.io/jq/">./JQ</a> before running these Curl commands.
<div>
<strong>To get a new token</strong> <br/>
<code>
curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=password&username=user&password=password" | jq
</code>

<br/>
<strong>To get a refresh token</strong><br/>
<code>
curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=access_token&access_tokem=[ACCESS_TOKEN]" | jq
</code>


<br/>
<strong>To access a protected resource</strong><br/>
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
<code>
curl -H "Authorization: Bearer $(curl trusted-app:secret@localhost:8080/oauth/token -d "grant_type=password&username=user&password=password" | jq --raw-output ."access_token")" localhost:8080/api/me | jq
</code>
</p>
</div>