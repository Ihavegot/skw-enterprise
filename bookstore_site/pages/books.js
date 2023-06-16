import {useState} from "react";

export default function BooksListPage() {
    const [data, setData] = useState();
    const callAPI = async () => {
        try {
            const req = await fetch(`http://localhost:8080/books/0/30`);
            const res = await req.json();
            setData(res);
        } catch (err) {
            console.log(err);
        }
    };

    return (
        <>
            <div>
                <button onClick={callAPI}>setdata</button>
                {data != null ?
                    data.content.map((value, key) => (
                        <div key={key}>
                            <p>BOOK IMAGE</p>
                            <p>TITLE: {value.title}, AUTHOR: {value.author}, GENRE: {value.genre}</p>
                        </div>
                    )) : ""}
            </div>
        </>
    );
}