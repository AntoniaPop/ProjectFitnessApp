package ro.app.controller;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import ro.app.App;
import ro.app.controller.DietController;
import ro.app.model.Diet;
import ro.app.service.DietService;
import java.util.Optional;

@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc // This annotation will automatically configure MockMvc for you
public class DietControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DietService dietService;

    // Before each test, we set up the mock data
    @BeforeEach
    public void setUp() {
        // This is where the mock setup will happen, but @MockBean already initializes it for you
    }

    @Test
    public void testCreateDiet() throws Exception {
        // Dieta de test
        Diet diet = new Diet("Keto", "A high-fat, low-carb diet", null);
        diet.setId(1L); // Setăm un ID pentru test

        // Mock-uim serviciul pentru a returna dieta creată
        when(dietService.createDiet(any(Diet.class))).thenReturn(diet);

        // Folosim MockMvc pentru a testa endpoint-ul
        mockMvc.perform(post("/diets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Keto\",\"description\":\"A high-fat, low-carb diet\"}")
                )
                .andExpect(status().isCreated()) // Verificăm că statusul este 201 Created
                .andExpect(jsonPath("$.name").value("Keto"))
                .andExpect(jsonPath("$.description").value("A high-fat, low-carb diet"));
    }

    @Test
    public void testGetDietById() throws Exception {
        Diet diet = new Diet("Keto", "A high-fat, low-carb diet", null);
        diet.setId(1L);

        when(dietService.getDietById(1L)).thenReturn(Optional.of(diet));

        mockMvc.perform(get("/diets/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Keto"))
                .andExpect(jsonPath("$.description").value("A high-fat, low-carb diet"));
    }

    @Test
    public void testGetAllDiets() throws Exception {
        Diet diet1 = new Diet("Keto", "A high-fat, low-carb diet", null);
        Diet diet2 = new Diet("Vegan", "A plant-based diet", null);

        List<Diet> diets = Arrays.asList(diet1, diet2);

        when(dietService.getAllDiets()).thenReturn(diets);

        mockMvc.perform(get("/diets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("[1].name").value("Vegan"));
    }

}
