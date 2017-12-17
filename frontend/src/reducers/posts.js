import * as types from '../constants/ActionTypes';
import _ from 'lodash';

const initialState = {
    posts: [],
    postsById: {}
};

export default function posts (state = initialState, action) {
    switch (action.type) {
        case types.ADD_POSTS: {
            // Here an actionData is the array with all posts
            let actionData = action.data;
            let newPosts = state.posts.concat(actionData);

            return {
                posts: newPosts,
                postsById: _.keyBy(newPosts, 'id')
            };
        }
        case types.REMOVE_POST: {
            let id = action.id;
            let resultPosts = state.posts.filter(p => p.id !== id);
            let resultPostById = {...state.postsById};
            delete resultPostById[id];

            return {resultPosts, resultPostById};

        }
        default:
            return state;
    }
}
