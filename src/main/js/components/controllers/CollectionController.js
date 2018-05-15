import React, {Component} from 'react'
import CollectionView from '../views/CollectionView'
import axios from 'axios'
import {API_URL} from "../../consts";

export default class CollectionController extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: props.match.params.keyWord,
            cards: null
        }
    }

    componentDidMount() {
        let {match: {params: {category, keyWord}}} = this.props;
        console.log(category, '/', keyWord);
        axios.get(`${API_URL}/${category}/${keyWord}`)
            .then(resp => {this.setState({cards:resp.data});console.log(resp);})
            .catch(err => console.error(err));
    }

    componentDidUpdate(prevProps, prevState) {
        if (prevProps.match.params.keyWord !== this.props.match.params.keyWord) {
            let {match: {params: {category, keyWord}}} = this.props;
            console.log(category, '/', keyWord);
            axios.get(`${API_URL}/${category}/${keyWord}`)
                .then(resp => {this.setState({name: keyWord, cards:resp.data});console.log(resp);})
                .catch(err => console.error(err));
        }
    }


    render() {
        return (!this.state.cards ? <div>Loading...</div> :
            <CollectionView name={this.state.name} cards={this.state.cards}/>)
    }
}