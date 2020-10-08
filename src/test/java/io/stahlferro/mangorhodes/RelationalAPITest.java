package io.stahlferro.mangorhodes;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RelationalAPITest {
    //    @Autowired
//    private WebApplicationContext context;
    @Autowired
    private MockMvc mockMvc;

//    @BeforeAll
//    public void setup() {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//
//    }

    @Test
//    @WithMockUser
    public void departmentAndRoomAddAndDelete() throws Exception {
        String newDepartment = new JSONObject()
                .put("name", "Worst Department")
                .put("code", "WRS")
                .toString();

        log.info("DEPARTMENT\n" + newDepartment);

        MvcResult result = mockMvc.perform(post("/api/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newDepartment)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Worst Department"))
                .andExpect(jsonPath("$.code").value("WRS"))
                .andExpect(jsonPath("$.creationTimestamp").exists())
                .andExpect(jsonPath("$.modificationTimestamp").exists())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        JSONObject savedDepartmentJSON = new JSONObject(content);
        String savedDepartmentId = savedDepartmentJSON.getString("id");

        JSONObject departmentIdForeignKey = new JSONObject()
                .put("id", savedDepartmentId);

        String newRoom = new JSONObject()
                .put("name", "Worst Room")
                .put("accessLevel", 420)
                .put("department", departmentIdForeignKey)
                .toString();

        log.info("ROOM\n" + newRoom);

        MvcResult roomResult = mockMvc.perform(post("/api/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newRoom)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Worst Room"))
                .andExpect(jsonPath("$.accessLevel").value("420"))
                .andExpect(jsonPath("$.department").exists())
                .andExpect(jsonPath("$.creationTimestamp").exists())
                .andExpect(jsonPath("$.modificationTimestamp").exists())
                .andReturn();

        String roomContent = roomResult.getResponse().getContentAsString();
        JSONObject savedRoomJSON = new JSONObject(roomContent);
        String savedRoomId = savedRoomJSON.getString("id");

        log.info("Performing deletion of:\n" + "DepartmentId: " + savedDepartmentId + "\n" + "RoomId: " + savedRoomId);
        this.mockMvc.perform(delete("/api/rooms/" + savedRoomId))
                .andExpect(status().isOk());
        log.info("Room deleted");
        this.mockMvc.perform(delete("/api/departments/" + savedDepartmentId))
                .andExpect(status().isOk());
        log.info("Department deleted");


    }
}
