package training.javatrainings;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.DocumentReader;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

//@Component
@RequiredArgsConstructor
@Slf4j
public class TrainingsLoader {

    private final VectorStore vectorStore;

    @PostConstruct
    public void loadTrainings() throws Exception {
        log.info("Loading trainings...");
        var documents = Files.list(Path.of("input"))
                .flatMap(file -> {
                    DocumentReader reader = new TextReader(new FileSystemResource(file));
                    return reader.read().stream();
                }).toList();
        vectorStore.accept(documents);
        log.info("Loaded {} documents", documents.size());
    }
}
