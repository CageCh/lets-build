package ca.uhn.fhir.letsbuild.upload;

import com.google.common.base.Charsets;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CsvDataUploader {

    public static void main(String[] theArgs) throws Exception {

        try (InputStream inputStream = new FileInputStream("src/main/resources/sample-data.csv")) {
            Reader reader = new InputStreamReader(inputStream, Charsets.UTF_8);

            CSVFormat format = CSVFormat.EXCEL
                    .withFirstRecordAsHeader()
                    .withDelimiter(',');
            CSVParser csvParser = format.parse(reader);

            for (CSVRecord nextRecord : csvParser.getRecords()) {

                // Sequence number - This could be used as an ID for generated resources
                String seqN = nextRecord.get("SEQN");

                // Timestamp - This will be formatted in ISO8601 format
                String timestamp = nextRecord.get("TIMESTAMP");

                // Patient ID
                String patientId = nextRecord.get("PATIENT_ID");

                // Patient Family Name
                String patientFamilyName = nextRecord.get("PATIENT_FAMILYNAME");

                // Patient Given Name
                String patientGivenName = nextRecord.get("PATIENT_GIVENNAME");

                // Patient Gender - Values will be "M" or "F"
                String patientGender = nextRecord.get("PATIENT_GENDER");

                // White blood cell count - This corresponds to LOINC code:
                // Code:        6690-2
                // Display:     Leukocytes [#/volume] in Blood by Automated count
                // Unit System: http://unitsofmeasure.org
                // Unit Code:   10*3/uL
                String wbc = nextRecord.get("LBXWBCSI");


                String lymphocyte = nextRecord.get("LBXLYPCT");


            }
        }
    }

}