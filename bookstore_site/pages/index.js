import Head from 'next/head'
import Image from 'next/image'
import {Inter} from 'next/font/google'
import styles from '@/styles/Home.module.css'
import {useEffect, useState} from "react";

const inter = Inter({subsets: ['latin']})

export default function Home() {
    const [data, setData] = useState([]);
    const callAPI = async () => {
        try {
            const req = await fetch(`http://localhost:8080/books`);
            const res = await req.json();
            setData(res)
        } catch (err) {
            console.log(err);
        }
    };

    return (
        <>
            <Head>
                <title>Create Next App</title>
            </Head>
            <main className={styles.main}>
                <div>
                    <button onClick={callAPI}>CALL API</button>
                    {data.map((item, key) => (
                        <p key={key}>
                            {item.title} ||
                            {item.author} ||
                            {item.genre} ||
                        </p>
                    ))}
                </div>
            </main>
        </>
    )
}
