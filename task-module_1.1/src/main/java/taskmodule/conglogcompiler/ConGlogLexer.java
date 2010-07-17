// $ANTLR 3.2 Sep 23, 2009 14:05:07 C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g 2010-04-29 16:55:01

	package taskmodule.conglogcompiler;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConGlogLexer extends Lexer {
    public static final int T__42=42;
    public static final int INTEGER=6;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int LETTER=8;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=11;
    public static final int IGNORE=12;
    public static final int EOF=-1;
    public static final int EMPTY=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int MULTILINE_COMMENT=14;
    public static final int T__16=16;
    public static final int T__33=33;
    public static final int T__15=15;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__35=35;
    public static final int NEGATION=4;
    public static final int NEWLINE=10;
    public static final int T__17=17;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int IDENT=5;
    public static final int DIGIT=9;
    public static final int COMMENT=13;

    // delegates
    // delegators

    public ConGlogLexer() {;} 
    public ConGlogLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ConGlogLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:11:7: ( 'Precondition-axioms' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:11:9: 'Precondition-axioms'
            {
            match("Precondition-axioms"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:12:7: ( '(' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:12:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:13:7: ( ')' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:13:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:14:7: ( '=' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:14:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:15:7: ( ';' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:15:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:16:7: ( 'true' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:16:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:17:7: ( 'false' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:17:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:18:7: ( '+' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:18:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:19:7: ( '-' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:19:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:20:7: ( '*' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:20:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:21:7: ( '/' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:21:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:22:7: ( 'mod' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:22:9: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:23:7: ( '!=' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:23:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:24:7: ( '<' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:24:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:25:7: ( '<=' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:25:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:26:7: ( '>' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:26:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:27:7: ( '>=' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:27:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:28:7: ( 'not' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:28:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:29:7: ( '&&' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:29:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:30:7: ( '||' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:30:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:31:7: ( '{' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:31:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:32:7: ( '}' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:32:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:33:7: ( '[' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:33:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:34:7: ( '|' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:34:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:35:7: ( ']' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:35:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:36:7: ( '?' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:36:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:37:7: ( 'Label' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:37:9: 'Label'
            {
            match("Label"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:38:7: ( ':' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:38:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:341:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:341:19: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:342:17: ( ( '0' .. '9' ) )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:342:19: ( '0' .. '9' )
            {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:342:19: ( '0' .. '9' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:342:20: '0' .. '9'
            {
            matchRange('0','9'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:343:18: ( ( '\\n' | '\\r' ) )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:343:20: ( '\\n' | '\\r' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:344:21: ( ( ' ' | '\\t' ) )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:344:23: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "EMPTY"
    public final void mEMPTY() throws RecognitionException {
        try {
            int _type = EMPTY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:345:7: ( 'empty' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:345:9: 'empty'
            {
            match("empty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EMPTY"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:346:9: ( ( DIGIT )+ )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:346:11: ( DIGIT )+
            {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:346:11: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:346:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:347:7: ( LETTER ( LETTER | DIGIT | '_' )* )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:347:9: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:347:16: ( LETTER | DIGIT | '_' )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt2=1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt2=2;
                    }
                    break;
                case '_':
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:347:17: LETTER
            	    {
            	    mLETTER(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:347:26: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;
            	case 3 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:347:34: '_'
            	    {
            	    match('_'); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "IGNORE"
    public final void mIGNORE() throws RecognitionException {
        try {
            int _type = IGNORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:348:8: ( ( WHITESPACE | NEWLINE )+ )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:348:10: ( WHITESPACE | NEWLINE )+
            {
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:348:10: ( WHITESPACE | NEWLINE )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             _channel = HIDDEN ; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IGNORE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:349:9: ( '//' ( . )* ( '\\n' | '\\r' ) )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:349:11: '//' ( . )* ( '\\n' | '\\r' )
            {
            match("//"); 

            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:349:16: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                    alt4=2;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:349:16: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:350:19: ( '/*' ( . )* '*/' )
            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:350:21: '/*' ( . )* '*/'
            {
            match("/*"); 

            // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:350:26: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='*') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='/') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='.')||(LA5_1>='0' && LA5_1<='\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<=')')||(LA5_0>='+' && LA5_0<='\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:350:26: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("*/"); 

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | EMPTY | INTEGER | IDENT | IGNORE | COMMENT | MULTILINE_COMMENT )
        int alt6=34;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:178: EMPTY
                {
                mEMPTY(); 

                }
                break;
            case 30 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:184: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 31 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:192: IDENT
                {
                mIDENT(); 

                }
                break;
            case 32 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:198: IGNORE
                {
                mIGNORE(); 

                }
                break;
            case 33 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:205: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 34 :
                // C:\\Documents and Settings\\Administrator\\workspace\\task-module\\src\\main\\java\\taskmodule\\conglogcompiler\\ConGlog.g:1:213: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\1\34\4\uffff\2\34\3\uffff\1\43\1\34\1\uffff\1\46\1\50"+
        "\1\34\1\uffff\1\53\5\uffff\1\34\1\uffff\1\34\3\uffff\3\34\3\uffff"+
        "\1\34\4\uffff\1\34\2\uffff\5\34\1\70\1\71\3\34\1\75\1\34\2\uffff"+
        "\3\34\1\uffff\1\102\1\103\1\104\1\34\3\uffff\6\34\1\uffff";
    static final String DFA6_eofS =
        "\114\uffff";
    static final String DFA6_minS =
        "\1\11\1\162\4\uffff\1\162\1\141\3\uffff\1\52\1\157\1\uffff\2\75"+
        "\1\157\1\uffff\1\174\5\uffff\1\141\1\uffff\1\155\3\uffff\1\145\1"+
        "\165\1\154\3\uffff\1\144\4\uffff\1\164\2\uffff\1\142\1\160\1\143"+
        "\1\145\1\163\2\60\1\145\1\164\1\157\1\60\1\145\2\uffff\1\154\1\171"+
        "\1\156\1\uffff\3\60\1\144\3\uffff\1\151\1\164\1\151\1\157\1\156"+
        "\1\55\1\uffff";
    static final String DFA6_maxS =
        "\1\175\1\162\4\uffff\1\162\1\141\3\uffff\1\57\1\157\1\uffff\2\75"+
        "\1\157\1\uffff\1\174\5\uffff\1\141\1\uffff\1\155\3\uffff\1\145\1"+
        "\165\1\154\3\uffff\1\144\4\uffff\1\164\2\uffff\1\142\1\160\1\143"+
        "\1\145\1\163\2\172\1\145\1\164\1\157\1\172\1\145\2\uffff\1\154\1"+
        "\171\1\156\1\uffff\3\172\1\144\3\uffff\1\151\1\164\1\151\1\157\1"+
        "\156\1\55\1\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\2\uffff\1\10\1\11\1\12\2\uffff\1\15\3"+
        "\uffff\1\23\1\uffff\1\25\1\26\1\27\1\31\1\32\1\uffff\1\34\1\uffff"+
        "\1\36\1\37\1\40\3\uffff\1\41\1\42\1\13\1\uffff\1\17\1\16\1\21\1"+
        "\20\1\uffff\1\24\1\30\14\uffff\1\14\1\22\3\uffff\1\6\4\uffff\1\7"+
        "\1\33\1\35\6\uffff\1\1";
    static final String DFA6_specialS =
        "\114\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\35\2\uffff\1\35\22\uffff\1\35\1\15\4\uffff\1\21\1\uffff"+
            "\1\2\1\3\1\12\1\10\1\uffff\1\11\1\uffff\1\13\12\33\1\31\1\5"+
            "\1\16\1\4\1\17\1\27\1\uffff\13\34\1\30\3\34\1\1\12\34\1\25\1"+
            "\uffff\1\26\3\uffff\4\34\1\32\1\7\6\34\1\14\1\20\5\34\1\6\6"+
            "\34\1\23\1\22\1\24",
            "\1\36",
            "",
            "",
            "",
            "",
            "\1\37",
            "\1\40",
            "",
            "",
            "",
            "\1\42\4\uffff\1\41",
            "\1\44",
            "",
            "\1\45",
            "\1\47",
            "\1\51",
            "",
            "\1\52",
            "",
            "",
            "",
            "",
            "",
            "\1\54",
            "",
            "\1\55",
            "",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "",
            "\1\61",
            "",
            "",
            "",
            "",
            "\1\62",
            "",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\72",
            "\1\73",
            "\1\74",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\76",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\105",
            "",
            "",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | EMPTY | INTEGER | IDENT | IGNORE | COMMENT | MULTILINE_COMMENT );";
        }
    }
 

}