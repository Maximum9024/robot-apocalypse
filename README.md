# robot-apocalypse
spring boot project  for robot apocalypse

open the project using an IDE e.g eclipse, intelliJ
run maven command on projects terminal : mvn clean install -DskipTests 
run the project as spring boot app.

Project Apis:
########################################################
register survivor
Method:POST
url :localhost:7000/api/survivor/register/newSurvivor
request :
{
    "id": 2425,
    "name":"Shane",
    "age":"19",
    "gender":"male",
    "lastLocation":{
        "latitude":"-25.896401481051676",
        "longitude":"28.11401579237846"
    },
    "inventory":["Ammunation","Drone","Food"]
}

#######################################################
get list of all survivors
Method:GET
url :localhost:7000/api/survivor/register/GetAllSurvivors

flag a survivor 
url: localhost:7000/api/survivor/flag/2425
NB: survivor flagged using the id.
    gets flagged when request ran 3 times.

#######################################################
update survivor
NB: updates the survivors location.
Method:PUT
url: localhost:7000/api/survivor/update/2425
request:
{
"lastLocation": {
            "id": 1,
            "latitude": "-27.896401481051676",
            "longitude": "30.11401579237846"
                }
}
##########################################################
list of robots report
Method:GET
url : http://localhost:7000/api/report/robot/pdf
NB: generates a report with a list of robots.

########################################################
list of survivors report
Method:GET
url:http://localhost:7000/api/report/survivor/pdf
NB: generates a list of survivors report(infected & non infected) and their percentages.



Thats All!!!.
