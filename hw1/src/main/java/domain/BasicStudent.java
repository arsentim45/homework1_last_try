package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair studentName = new JsonPair("name", new JsonString(this.name));
        JsonPair studentSurname = new JsonPair("surname", new JsonString(this.surname));
        JsonPair studentYear = new JsonPair("year", new JsonNumber(this.year));

        return new JsonObject(studentName, studentSurname, studentYear);
    }
}
