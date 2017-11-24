import React, { Component } from 'react';
import { connect } from 'react-redux';

function mapStateToProps(state) {
    return { 
      deletedPost: state.posts.deletedPost,
      authenticatedUser: state.user.status === 'authenticated' ? state.user.user : null,
      user: state.user
    };
  }
  