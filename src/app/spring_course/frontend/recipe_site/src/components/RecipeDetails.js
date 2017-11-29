import React, { Component, PropTypes } from 'react';
import { Link } from 'react-router';

class RecipeDetails extends Component {
  
    componentWillUnmount() {
        //Important! If your component is navigating based on some global state(from say componentWillReceiveProps)
        //always reset that global state back to null when you REMOUNT
         this.props.resetMe();
      }
    
      componentDidMount() {
        this.props.fetchRecipe(this.props.recipeId);
      }

      render() {
        const { recipe, loading, error } = this.props.activeRecipe;
        if (loading) {
          return <div className="container">Loading...</div>;
            } else if(error) {
                return  <div className="alert alert-danger">{error.message}</div>
                } else if(!recipe) {
                    return <span />
                    }
       

        return (
            <div className="container">
              <h3>{recipe.name}</h3>
              <h6>Categories</h6>
              <p>{recipe.description}</p>
            </div>
          );
        }
    }

export default RecipeDetails;