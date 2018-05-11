import React, {Component} from 'react'
import axios from 'axios'
import {InputGroup, InputGroupAddon, Input, Button} from 'reactstrap'

const API_URL = "http://localhost:8080/api/v1/cards/search/";

class SearchBar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            keyWord: '',
        };
    }

    onClick() {
        console.log("on click");
        axios.get(API_URL + this.state.keyWord)
            .then(resp => {this.props.handleResult(resp.data)})
            .catch(error => console.error(error));
    }

    render() {
        return (
            <InputGroup>
                <Input placeholder="Name or Card ID"
                       value={this.state.keyWord}
                       onChange={e => this.setState({keyWord: e.target.value})}/>
                <InputGroupAddon addonType="append">
                    <Button color="primary" onClick={this.onClick.bind(this)}>Search</Button>
                </InputGroupAddon>
            </InputGroup>
        );
    }
}

export default SearchBar;