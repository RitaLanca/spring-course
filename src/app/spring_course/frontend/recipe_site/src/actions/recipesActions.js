import axios from 'axios';
import { SERVER_URL } from '../utils/GlobalConstants';





//Recipe list
export const FETCH_RECIPES = 'FETCH_RECIPES';
export const FETCH_RECIPES_SUCCESS = 'FETCH_RECIPES_SUCCESS';
export const FETCH_RECIPES_FAILURE = 'FETCH_RECIPES_FAILURE';

//Create new recipe
export const CREATE_RECIPE = 'CREATE_RECIPE';
export const CREATE_RECIPE_SUCCESS = 'CREATE_RECIPE_SUCCESS';
export const CREATE_RECIPEFAILURE = 'CREATE_RECIPE_FAILURE';

//Validate recipes fields like Name, Author, Categories on the server
export const VALIDATE_RECIPES_FIELDS = 'VALIDATE_RECIPES_FIELDS';
export const VALIDATE_RECIPES_FIELDS_SUCCESS = 'VALIDATE_RECIPES_FIELDS_SUCCESS';
export const VALIDATE_RECIPES_FIELDS_FAILURE = 'VALIDATE_RECIPES_FIELDS_FAILURE';

//Fetch recipe
export const FETCH_RECIPE = 'FETCH_RECIPE';
export const FETCH_RECIPE_SUCCESS = 'FETCH_RECIPE_SUCCESS';
export const FETCH_RECIPE_FAILURE = 'FETCH_RECIPE_FAILURE';
export const RESET_ACTIVE_RECIPE = 'RESET_ACTIVE_RECIPE';

//Delete recipe
export const DELETE_RECIPE = 'DELETE_POST';
export const DELETE_RECIPE_SUCCESS = 'DELETE_RECIPE_SUCCESS';
export const DELETE_RECIPE_FAILURE = 'DELETE_RECIPE_FAILURE';
export const RESET_DELETED_RECIPE = 'RESET_DELETED_RECIPE';


export function fetchRecipes() {
    const request = axios({
      method: 'get',
      url: `${SERVER_URL}`,
      headers: []
    });
  
    return {
      type: FETCH_RECIPES,
      payload: request
    };
  }


  export function fetchRecipesSuccess(recipes) {
    return {
      type: FETCH_RECIPES_SUCCESS,
      payload: recipes
    };
  }
  
  export function fetchPostsFailure(error) {
    return {
      type: FETCH_RECIPES_FAILURE,
      payload: error
    };
  }


  export function createRecipe(authorId, successCallback, failedCallback) {
    const request = axios.post(SERVER_URL + '/recipe/add', recipe, {params:authorId} );
  
    return {
      type: CREATE_RECIPE,
      payload: request
    };
  }
  
  export function createRecipeSuccess(newRecipe) {
    return {
      type: CREATE_RECIPE_SUCCESS,
      payload: newPost
    };
  }
  
  export function createRecipeFailure(error) {
    return {
      type: CREATE_RECIPE_FAILURE,
      payload: error
    };
  }
  
  