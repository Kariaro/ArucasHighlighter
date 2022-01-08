/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package me.hardcoded.arucas.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.psi.ArucasTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Arucas.flex</tt>
 */
class ArucasLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING_DOUBLE = 2;
  public static final int STRING_SINGLE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [8, 6, 7]
   * Total runtime size is 1040 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>13]|((ch>>7)&0x3f)]|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 136 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\207\100");

  /* The ZZ_CMAP_Y table has 128 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\177\200");

  /* The ZZ_CMAP_A table has 256 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\26\1\25\1\0\1\26\1\24\22\0\1\26\1\37\1\47\3\0\1\45\1\50\2\40\1\34"+
    "\1\33\1\46\1\32\1\31\1\35\12\30\1\40\1\46\1\43\1\41\1\42\2\0\32\27\1\40\1"+
    "\51\1\40\1\36\1\27\1\0\1\10\1\22\1\11\1\27\1\3\1\2\1\27\1\12\1\1\1\27\1\23"+
    "\1\4\1\27\1\17\1\6\1\20\1\27\1\7\1\5\1\14\1\16\1\21\1\13\1\27\1\15\1\27\1"+
    "\40\1\44\1\40\202\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\15\2\1\3\1\4\1\5\5\6\1\5"+
    "\2\1\1\7\1\10\1\11\1\12\1\13\3\12\1\14"+
    "\22\2\2\0\1\15\1\12\1\14\16\2\1\4\2\0"+
    "\2\15\7\2\1\16\1\2\1\0\5\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[94];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\52\0\124\0\176\0\250\0\322\0\374\0\u0126"+
    "\0\u0150\0\u017a\0\u01a4\0\u01ce\0\u01f8\0\u0222\0\u024c\0\u0276"+
    "\0\u02a0\0\u02ca\0\u02f4\0\176\0\u031e\0\u0348\0\176\0\u0372"+
    "\0\u039c\0\u039c\0\u03c6\0\u03f0\0\176\0\176\0\176\0\u041a"+
    "\0\176\0\u0444\0\u046e\0\u0498\0\u0126\0\u04c2\0\u04ec\0\u0516"+
    "\0\u0540\0\u056a\0\u0594\0\u05be\0\u05e8\0\u0612\0\u063c\0\u0666"+
    "\0\u0690\0\u06ba\0\u06e4\0\u070e\0\u0738\0\u0762\0\u078c\0\u07b6"+
    "\0\u07e0\0\u080a\0\176\0\u0834\0\u085e\0\u0888\0\u08b2\0\u08dc"+
    "\0\u0906\0\u0930\0\u095a\0\u0984\0\u09ae\0\u09d8\0\u0a02\0\u0a2c"+
    "\0\u0a56\0\u0a80\0\u07b6\0\u0aaa\0\u0ad4\0\u0afe\0\176\0\u0b28"+
    "\0\u0b52\0\u0b7c\0\u0ba6\0\u0bd0\0\u0bfa\0\u0c24\0\u0126\0\u0c4e"+
    "\0\u0c78\0\u0ca2\0\u0ccc\0\u0cf6\0\u0d20\0\u0d4a";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[94];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\10\1\14\1\10\1\15\1\16\2\10\1\17\1\10"+
    "\1\20\1\21\1\10\3\22\1\10\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\27\1\31\1\24\3\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\4\24\40\2\4\21\40"+
    "\1\41\1\40\1\42\24\43\2\4\22\43\1\41\1\44"+
    "\53\0\1\10\1\45\21\10\3\0\2\10\22\0\5\10"+
    "\1\46\1\10\1\47\5\10\1\50\5\10\3\0\2\10"+
    "\22\0\3\10\1\51\17\10\3\0\2\10\22\0\23\10"+
    "\3\0\2\10\22\0\12\10\1\52\1\53\7\10\3\0"+
    "\2\10\22\0\17\10\1\54\3\10\3\0\2\10\22\0"+
    "\2\10\1\55\20\10\3\0\2\10\22\0\3\10\1\56"+
    "\1\10\1\57\1\10\1\60\13\10\3\0\2\10\22\0"+
    "\11\10\1\61\11\10\3\0\2\10\22\0\6\10\1\62"+
    "\2\10\1\63\11\10\3\0\2\10\22\0\2\10\1\64"+
    "\12\10\1\65\5\10\3\0\2\10\22\0\7\10\1\66"+
    "\13\10\3\0\2\10\22\0\6\10\1\67\14\10\3\0"+
    "\2\10\45\0\3\22\53\0\1\23\1\70\52\0\1\27"+
    "\7\0\1\24\42\0\1\27\52\0\1\71\1\72\55\0"+
    "\1\24\54\0\1\24\52\0\1\24\4\0\24\40\2\0"+
    "\21\40\1\0\1\40\10\0\1\73\4\0\1\73\2\0"+
    "\1\73\27\0\1\73\1\0\1\73\24\43\2\0\22\43"+
    "\11\0\1\73\4\0\1\73\2\0\1\73\30\0\2\73"+
    "\1\0\6\10\1\74\14\10\3\0\2\10\22\0\3\10"+
    "\1\75\17\10\3\0\2\10\22\0\16\10\1\45\4\10"+
    "\3\0\2\10\22\0\4\10\1\76\16\10\3\0\2\10"+
    "\22\0\1\77\22\10\3\0\2\10\22\0\7\10\1\100"+
    "\13\10\3\0\2\10\22\0\2\10\1\101\20\10\3\0"+
    "\2\10\22\0\13\10\1\102\7\10\3\0\2\10\22\0"+
    "\7\10\1\103\13\10\3\0\2\10\22\0\16\10\1\104"+
    "\4\10\3\0\2\10\22\0\4\10\1\76\6\10\1\105"+
    "\7\10\3\0\2\10\22\0\1\106\22\10\3\0\2\10"+
    "\22\0\14\10\1\45\1\107\5\10\3\0\2\10\22\0"+
    "\1\110\22\10\3\0\2\10\22\0\12\10\1\45\10\10"+
    "\3\0\2\10\22\0\3\10\1\111\17\10\3\0\2\10"+
    "\22\0\6\10\1\45\14\10\3\0\2\10\22\0\2\10"+
    "\1\112\20\10\3\0\2\10\51\0\1\113\21\0\34\114"+
    "\1\115\15\114\24\72\1\116\1\117\24\72\1\0\2\10"+
    "\1\120\20\10\3\0\2\10\22\0\4\10\1\107\16\10"+
    "\3\0\2\10\22\0\2\10\1\45\20\10\3\0\2\10"+
    "\22\0\13\10\1\105\7\10\3\0\2\10\22\0\13\10"+
    "\1\121\7\10\3\0\2\10\22\0\6\10\1\122\14\10"+
    "\3\0\2\10\22\0\15\10\1\123\5\10\3\0\2\10"+
    "\22\0\4\10\1\124\16\10\3\0\2\10\22\0\13\10"+
    "\1\125\7\10\3\0\2\10\22\0\10\10\1\126\12\10"+
    "\3\0\2\10\22\0\3\10\1\76\17\10\3\0\2\10"+
    "\22\0\2\10\1\127\20\10\3\0\2\10\22\0\4\10"+
    "\1\127\16\10\3\0\2\10\22\0\3\10\1\127\17\10"+
    "\3\0\2\10\22\0\7\10\1\130\13\10\3\0\2\10"+
    "\21\0\34\114\1\131\15\114\34\0\1\115\1\117\41\0"+
    "\1\117\25\0\7\10\1\105\13\10\3\0\2\10\22\0"+
    "\1\132\22\10\3\0\2\10\22\0\7\10\1\133\13\10"+
    "\3\0\2\10\22\0\6\10\1\50\14\10\3\0\2\10"+
    "\22\0\4\10\1\45\16\10\3\0\2\10\22\0\1\134"+
    "\22\10\3\0\2\10\22\0\11\10\1\45\11\10\3\0"+
    "\2\10\22\0\22\10\1\45\3\0\2\10\21\0\34\114"+
    "\1\131\1\117\14\114\1\0\10\10\1\45\12\10\3\0"+
    "\2\10\22\0\13\10\1\135\7\10\3\0\2\10\22\0"+
    "\16\10\1\136\4\10\3\0\2\10\22\0\5\10\1\66"+
    "\15\10\3\0\2\10\22\0\15\10\1\76\5\10\3\0"+
    "\2\10\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3444];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\17\1\1\11\2\1\1\11\5\1\3\11"+
    "\1\1\1\11\26\1\2\0\1\1\1\11\20\1\2\0"+
    "\1\1\1\11\11\1\1\0\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[94];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  ArucasLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 15: break;
          case 2: 
            { return ArucasTypes.IDENTIFIER;
            } 
            // fall through
          case 16: break;
          case 3: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 17: break;
          case 4: 
            { return ArucasTypes.NUMBER;
            } 
            // fall through
          case 18: break;
          case 5: 
            { return ArucasTypes.SYNTAX;
            } 
            // fall through
          case 19: break;
          case 6: 
            { return ArucasTypes.OPERATOR;
            } 
            // fall through
          case 20: break;
          case 7: 
            { return ArucasTypes.DELIMITER;
            } 
            // fall through
          case 21: break;
          case 8: 
            { yybegin(STRING_DOUBLE);
            } 
            // fall through
          case 22: break;
          case 9: 
            { yybegin(STRING_SINGLE);
            } 
            // fall through
          case 23: break;
          case 10: 
            { 
            } 
            // fall through
          case 24: break;
          case 11: 
            { yybegin(YYINITIAL); return ArucasTypes.STRING;
            } 
            // fall through
          case 25: break;
          case 12: 
            { return ArucasTypes.KEYWORD;
            } 
            // fall through
          case 26: break;
          case 13: 
            { return ArucasTypes.COMMENT;
            } 
            // fall through
          case 27: break;
          case 14: 
            { return ArucasTypes.VALUE_KEYWORD;
            } 
            // fall through
          case 28: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
