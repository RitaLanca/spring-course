/*import React, {Component} from 'react';
import { connect } from 'react-redux';
import { Field, reduxForm } from 'redux-form';



class SearchRecipes extends Component {
    constructor(props) {
        super(props);

        this.state= {term: '' };
    }
    render(){
        return (
         <div className='searchbar-container'>
            <form className='container-fluid'
                onSubmit={this.props.handleSubmit(this.onSubmit.bind(this))}>
                <Field name="hashtag" className="textarea" type="text" 
                component={this.renderField.bind(this)} 
                />
            </form>
         </div>
               );
        }

   
}

 //Function that render search bar inside form {/* onChange={this.onInputChange.bind(this)}  */}


{/*
 renderField(field) {
    return (
        <div id="searchBar">
            <div className="input-group stylish-input-group">
                <input name="search" id="search" type="text" className="form-control" 
                    {...field.input} 
                    placeholder='Search for recipes, ingredients, categories or authors' 
                    size='80'
                />
                <span className="input-group-addon">
                    <button type="submit">
                        <span className="glyphicon glyphicon-search"></span>
                    </button>
                </span>
            </div>
        </div>
    )
}




export default SearchRecipes;
}