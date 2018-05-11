import React, {Component} from 'react';
import { render } from 'react-dom';
import {Row, Col} from 'reactstrap'
import SearchBar from './components/SearchBar'
import SearchResult from './components/SearchResult'
import CommonDetail from "./components/details/CommonDetail";


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
            <div className="container-fluid">
                <Row>
                    <Col>
                        <SearchBar handleResult={this.handleResult}/>
                        { this.state.cards && (<SearchResult
                            cards={this.state.cards}
                            handleResultClick={this.handleResultClick}/>)}
                    </Col>
                    {this.state.cardDisplayed && <Col><CommonDetail card={this.state.cardDisplayed}/></Col>}
                </Row>
            </div>
        );
    }
}


console.log(document.getElementById('react'));
render(<App />, document.getElementById('react'));
