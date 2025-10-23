package cz.stepan.seraializations;

public interface Serialization {

    String serialization(Object serializationObject);
    Object deserialization(String serializationObject);
}
