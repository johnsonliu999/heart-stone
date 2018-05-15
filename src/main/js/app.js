import React, {Component} from 'react';
import { render } from 'react-dom';
import {Row, Col} from 'reactstrap'
import SearchBar from './components/SearchBar'
import SearchResult from './components/SearchResult'
import CardDetail from "./components/details/CardDetail";
import {BrowserRouter as Router, Route, Link} from 'react-router-dom'
import CollectionController from './components/controllers/CollectionController';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            cards: null,
            cardDisplayed: null
        };
        this.handleResultClick = this.handleResultClick.bind(this);
        this.handleResult = this.handleResult.bind(this);
    }

    handleResult(cards) {this.setState({cards});}

    handleResultClick(cardDisplayed) {this.setState({cardDisplayed});}


    render() {
        return (
            <Router>
                <div className="container-fluid">
                    <SearchBar handleResult={this.handleResult}/>
                    <Route path={'/search/:keyWord'} render={() =>
                        <Row>
                            <Col><SearchResult cards={this.state.cards}
                                          handleResultClick={this.handleResultClick} />
                            </Col>
                            {this.state.cardDisplayed &&
                                <Col><CardDetail card={this.state.cardDisplayed}/></Col>}
                        </Row>} />
                    <Route path={'/collections/:category/:keyWord'}
                               component={CollectionController} />
                </div>
            </Router>
        );
    }
}


console.log(document.getElementById('react'));
render(<App />, document.getElementById('react'));
