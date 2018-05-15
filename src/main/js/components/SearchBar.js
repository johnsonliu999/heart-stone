import React, {Component} from 'react'
import axios from 'axios'
import {InputGroup, InputGroupAddon, Input, Button} from 'reactstrap'
import {API_URL} from "../consts";
import {UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem} from 'reactstrap'
import {withRouter} from 'react-router-dom'

const SEARCH_MAP = {
    'Fuzz': '/search/',
    'Name': '/',
    'Race': '/races/',
    'Quality': '/qualities/',
    'Faction': '/factions/',
    'Class': '/classes/',
    'Set': '/sets/',
    'Type': '/types/'
};

const OPTION_MAP = {
    'Race': 'races',
    'Quality': 'qualities',
    'Faction': 'factions',
    'Class': 'classes',
    'Set': 'sets',
    'Type': 'types'
};

class SearchBar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            keyWord: '',
            type: 'search', // enum: search or collection
            info: null, // get from API {classes: [], sets: [], ...}
            category: 'Fuzz'
        };

        this.onChangeCategory = this.onChangeCategory.bind(this);
        this.onSearch = this.onSearch.bind(this)
    }

    componentDidMount() {
        axios.get(`${API_URL}/info`)
            .then(resp => this.setState({info: resp.data}))
            .catch(err => console.error(err));
    }

    onSearch() {
        if (OPTION_MAP[this.state.category])
            this.props.history.push(`/collections/${OPTION_MAP[this.state.category]}/${this.state.keyWord}`);
        else
            axios.get(API_URL + SEARCH_MAP[this.state.category] + this.state.keyWord)
                .then(resp => {
                    this.props.handleResult(resp.data.error ? null : resp.data);
                    this.props.history.push(`/search/${this.state.keyWord}`);
                })
                .catch(error => console.error(error));
    }

    onChangeCategory(e) {
        this.setState({category: e.currentTarget.textContent, keyWord: ''})
    }

    render() {
        return (
            <InputGroup>
                {
                    !(this.state.info && this.state.info[OPTION_MAP[this.state.category]]) ?
                    <Input value={this.state.keyWord}
                           onChange={e => this.setState({keyWord: e.target.value})}/> :
                    <select className={"custom-select"} onChange={e => this.setState({keyWord: e.target.value})}>
                        <option defaultValue={''}>Please select a key word</option>
                        {this.state.info[OPTION_MAP[this.state.category]].map(s => <option key={s} value={s}>{s}</option>)}
                    </select>
                }
                <InputGroupAddon addonType="append">
                    <UncontrolledDropdown>
                        <DropdownToggle caret>
                            {this.state.category}
                        </DropdownToggle>
                        <DropdownMenu>
                            <DropdownItem onClick={this.onChangeCategory}>Fuzz</DropdownItem>
                            <DropdownItem onClick={this.onChangeCategory}>Name</DropdownItem>
                            <DropdownItem onClick={this.onChangeCategory}>Class</DropdownItem>
                            <DropdownItem onClick={this.onChangeCategory}>Faction</DropdownItem>
                            <DropdownItem onClick={this.onChangeCategory}>Quality</DropdownItem>
                            <DropdownItem onClick={this.onChangeCategory}>Race</DropdownItem>
                            <DropdownItem onClick={this.onChangeCategory}>Type</DropdownItem>
                            <DropdownItem onClick={this.onChangeCategory}>Set</DropdownItem>
                        </DropdownMenu>
                    </UncontrolledDropdown>
                    <Button color="primary" onClick={this.onSearch}>Search</Button>
                </InputGroupAddon>
            </InputGroup>
        );
    }
}

export default withRouter(SearchBar);