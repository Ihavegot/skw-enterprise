import Header from "@/pages/components/header";
import Books from "@/pages/components/getbooks";

export default function Background() {
    return (
        <>
            <div className="d-flex flex-column justify-content-center w-100 h-100">
                <Header></Header>
                <Books></Books>
            </div>
        </>
    )
}