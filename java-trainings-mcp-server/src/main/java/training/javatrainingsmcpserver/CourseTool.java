package training.javatrainingsmcpserver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CourseTool {

    private final CourseRepository courseRepository;

    @McpTool(name = "findCourseByCode", description = "Visszaadja a tanfolyamok adatait, időpontjait a tanfolyam kódja alapján")
    public List<Course> findCourseByCode(String code) {
        log.info("find course by code: {}", code);
        return courseRepository.findByCode(code);
    }
}
