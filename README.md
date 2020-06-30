##### anonymous 
`curl -v localhost:8080/person` = 200 ok

##### Correct user/pwd + role
`curl -v -u admin:password localhost:8080/persons` = 200 ok

`curl -v -u user:1234qwer localhost:8080/men` = 200 ok

##### correct user/pwd + incorrect role
`curl -v -u admin:password localhost:8080/men` = 500, should be 403

##### incorrect user/pwd
curl -v -u admin:pass localhost:8080/men = 500, should be 401
