import { connect } from 'react-redux'
import { fetchRecipes, fetchRecipesSuccess, fetchRecipesFailure } from '../actions/posts';
import RecipeList from '../components/RecipeList';


const mapStateToProps = (state) => {
  return { 
    RecipeList: state.posts.RecipeList
  };
}

const mapDispatchToProps = (dispatch) => {
  return {
    fetchRecipes: () => {
      dispatch(fetchRecipes()).then((response) => {
            !response.error ? dispatch(fetchRecipesSuccess(response.payload.data)) : dispatch(fetchRecipesFailure(response.payload.data));
          });
    }
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(RecipeList);