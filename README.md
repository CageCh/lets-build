# HAPI-FHIR Let's Build

# Precursors

* Check this project out to your local hard drive.
* Open it in an IDE
* Have the following tools installed:
   * [Java JDK Version 11.x.x](https://adoptopenjdk.net/) (This is the recommended version but Java 8 and above should also work)
   * [Apache Maven](https://maven.apache.org/)

# Step 1 - Build a FHIR Data Mapper

**Rationale:** When adopting FHIR, a common scenario is needing to convert your existing data into the FHIR model. This can be a challenging first step, but if you approach it systematically it can be easy. 

**Exercise:** For this exercise, we will be building a mapper that converts existing data a CSV file into FHIR Patient and Observation resources. 

We'll be using a sample data file from the CDC NHANES (National Health and Nutrition Examination Study) publicly available sample data set. The format of the data set is described at [this link](https://wwwn.cdc.gov/Nchs/Nhanes/2017-2018/CBC_J.htm) but we have reworked the format a bit to add fake patient identities and timestamps to the data.

The input CSV file can be found here: https://github.com/hapifhir/lets-build/blob/main/src/main/resources/sample-data.csv 

## Approach

The input data looks like the following:

```csv
SEQN   ,TIMESTAMP               ,PATIENT_ID,PATIENT_FAMILYNAME,PATIENT_GIVENNAME,PATIENT_GENDER,WBC,RBC,HB
93704.0,2020-11-13T07:47:35.964Z,PT00002   ,Simpson           ,Marge            ,F             ,7.4,0.1,13.1
```

Note the columns:

* SEQN: This is a unique identifier for the test
* TIMESTAMP: This is the timestamp for the test
* Patient detail columns (note that the patients repeat so you will want to ):
   * PATIENT_ID: This is the ID of the patient
   * PATIENT_FAMILYNAME: This is the family (last) name of the patient
   * PATIENT_GIVENNAME: This is the given (first) name of the patient
   * PATIENT_GENDER: This is the gender of the patient
* Test result columns (each of these will be a separate Observation resource):
   * WBC: "White Blood Cells": This a count of the number

## Starting a local test server

From the root of this repository, execute the following command:

```bash
mvn clean jetty:run
```

This will take a minute or two to start, but eventually you'll see a message that looks like this:

> [INFO] Started @27659ms
> [INFO] Started Jetty Server

Try pointing your browser to the following URL to see the base URL of the server (you'll get a message that "This is the base URL of FHIR Server", this means it's working!)

http://localhost:8080/fhir


## Writting a Mapper

Open the following class 

 


## Hints:

* Don't optimize at first! There are lots of ways this code can be made efficient, but it's better to start by getting it working, then worry about performance later.

