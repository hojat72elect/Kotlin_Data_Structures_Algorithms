package data_structures.trie

/**
 * @author Hojat Ghasemi,
 * 2022-03-07
 * https://github.com/hojat72elect
 */
class TrieNode<Key>(var key: Key?, var parent: TrieNode<Key>?) {
    val children: HashMap<Key, TrieNode<Key>> = HashMap()
    var isTerminating = false
}