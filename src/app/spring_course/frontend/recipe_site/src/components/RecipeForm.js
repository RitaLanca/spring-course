import React, { Component, PropTypes } from 'react';
import { Link } from 'react-router-dom';
import { reduxForm, Field, SubmissionError } from 'redux-form';

import { validateRecipeFields, validateRecipeFieldsSuccess, validateRecipeFieldsFailure } from '../actions/recipesActions';
import { createRecipe, createRecipeSuccess, createRecipeFailure, resetNewRecipe } from '../actions/recipesActions';

//Client side validation
function validate(values) {
    const errors = {};
  
    if (!values.name || values.name.trim() === '') {
      errors.name = 'Enter a Name';
    }
    if (!values.categories || values.categories.trim() === '') {
      errors.categories = 'Enter categories';
    }
    if (!values.description || values.description.trim() === '') {
      errors.description = 'Enter some description';
    }
  
    return errors;
  }

  //For any field errors upon submission (i.e. not instant check)
    const validateAndCreateRecipe = (values, dispatch) => {
    return dispatch(createRecipe(values))
      .then(result => {
        // Note: Error's "data" is in result.payload.response.data (inside "response")
        // success's "data" is in result.payload.data
        if (result.payload.response && result.payload.response.status !== 200) {
          dispatch(createRecipeFailure(result.payload.response.data));
          throw new SubmissionError(result.payload.response.data);
        }
        //let other components know that everything is fine by updating the redux` state
        dispatch(createRecipeSuccess(result.payload.data)); //ps: this is same as dispatching RESET_USER_FIELDS
      });
  }

  class RecipeForm extends Component {
   
  
    componentWillMount() {
      //Important! If your component is navigating based on some global state(from say componentWillReceiveProps)
      //always reset that global state back to null when you REMOUNT
      this.props.resetMe();
    }
  
    componentWillReceiveProps(nextProps) {
      if (nextProps.newRecipe.recipe && !nextProps.newRecipe.error) {
        this.context.router.push('/');
      }
    }
  
    renderError(newRecipe) {
      if (newRecipe && newRecipe.error && newRecipe.error.message) {
        return (
          <div className="alert alert-danger">
            { newRecipe ? newRecipe.error.message : '' }
          </div>
          );
      } else {
        return <span></span>
      }
    }
    render() {
      const {handleSubmit, submitting, newRecipe} = this.props;
      return (
        <div className='container'>
          { this.renderError(newRecipe) }
          <form onSubmit={ handleSubmit(validateAndCreateRecipe) }>
            <Field
                   name="title"
                   type="text"
                   
                   label="Title*" />
            <Field
                   name="categories"
                   type="text"
                   label="Categories*" />
            <Field
                   name="content"
                   label="Content*" />
            <div>
              <button
                      type="submit"
                      className="btn btn-primary"
                      disabled={ submitting }>
                Submit
              </button>
              <Link
                    to="/"
                    className="btn btn-error"> Cancel
              </Link>
            </div>
          </form>
        </div>
      )
    }
  }
  
  
  export default reduxForm({
    form: 'RecipeForm', // a unique identifier for this form
    validate, // <--- validation function given to redux-form
  })(RecipeForm)
 