package com.backend.projectbank.service;

import com.backend.projectbank.entity.Recipe;
import com.backend.projectbank.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repository;

    public List<Recipe> findAll() {
        return repository.findAll();
    }

    public Recipe findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Recipe updateRecipe(Recipe recipe) {

        Recipe recipeUpdate = repository.findById(recipe.getId()).orElse(null);
        recipeUpdate.setNome(recipe.getNome());
        recipeUpdate.setIngredientes(recipe.getIngredientes());
        recipeUpdate.setModoPreparo(recipe.getModoPreparo());
        recipeUpdate.setTempoPreparo(recipe.getTempoPreparo());
        recipeUpdate.setCategoria(recipe.getCategoria());
        recipeUpdate.setDescricao(recipe.getDescricao());

        return repository.save(recipeUpdate);
    }

    public List<Recipe> findByKeyWord(String keyWord) {
        List<Recipe> allRecipes = repository.findAll();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {
            if (recipe.getNome().toLowerCase().contains(keyWord.toLowerCase())) {
                filteredRecipes.add(recipe);
            }
        }

        if (filteredRecipes.isEmpty()) {
            System.out.println("Nenhuma receita encontrada para: " + keyWord);
        }

        return filteredRecipes;
    }

}
