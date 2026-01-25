package net.serenitybdd.demos.todos.screenplay.Ability;

import java.nio.file.Path;
import java.util.Objects;

public class ResourceFile {
    public static Path file(String name) {
        try {
            return Path.of(
                    Objects.requireNonNull(
                            ResourceFile.class
                                    .getClassLoader()
                                    .getResource("files/" + name),
                            "No se encontró el archivo: " + name
                    ).toURI()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error cargando archivo: " + name, e);
        }
    }
}
