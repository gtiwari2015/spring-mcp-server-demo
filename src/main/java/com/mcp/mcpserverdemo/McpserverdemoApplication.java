package com.mcp.mcpserverdemo;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class McpserverdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpserverdemoApplication.class, args);
		}

		@Bean
		ToolCallbackProvider toolCallbackProvider(ScheduleInterview scheduleInterview){

			return MethodToolCallbackProvider.builder().toolObjects(scheduleInterview).build();



		}

	@Component
	public class ScheduleInterview {

		@Tool(description = "Schedule first round with the candidate with job poster")
		String scheduleFirstRound(@ToolParam(description = "the id of the job") int jobId, @ToolParam(description = "Description of found job") String jobDescirption){
			var screeningAppointment= Instant.now().plus(5, ChronoUnit.DAYS);
			System.out.println(" first job round appointment confirmed for"+screeningAppointment);
			return screeningAppointment.toString();
		}

	}
}
