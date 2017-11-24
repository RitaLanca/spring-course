




let initialState = {
    errors :[],
    recipesList: [],
    loaded:false,
    successMessage:null
}

export default function (state = initialState, action) {
    
        switch (action.type) {

            case recipesActions.FETCH_RECIPES_SUCCESS:// return list of recipes and make loading = true
                return { ...state, 
                    errors: [], 
                    recipesList: action.payload, 
                    loaded: true 
                };
            case recipesActions.FETCH_POSTS_FAILURE: // return error and make loading = false
                return { ...state, 
                    errors: action.payload 
                };
           
            default:
                return state;
        }
    }